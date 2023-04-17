package com.bsva.dcqs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsva.dcqs.util.DateFormatter;
import com.bsva.dcqs.enums.FileTypes;
import com.bsva.dcqs.model.DeliveryFileTypes;
import com.bsva.dcqs.repository.DeliveryFileTypesRepository;
import com.bsva.dcqs.repository.DeliveryFilesRepository;
import com.bsva.dcqs.service.DeliveryFileTypeServiceImpl;
import com.bsva.dcqs.service.DeliveryFileTypesService;
import com.bsva.dcqs.service.DeliveryFilesService;

import org.springframework.core.io.UrlResource;

@RestController
@RequestMapping(path = "/batch") // Root path
@RequiredArgsConstructor
@Slf4j
public class BatchController {

	private Logger logger = Logger.getLogger(BatchController.class.getName());
	private DateFormatter dateFormatter = new DateFormatter();

	private final JobLauncher jobLauncher;
	private final Job job;

	@Value("${spring.file-path}")
	private String path;

	@Value("${spring.temp-file-path}")
	private String tempFilepath;

	@Autowired
	DeliveryFileTypesService deliveryFileTypesService;
	
	@Autowired
	DeliveryFilesService deliveryFilesService;

	@GetMapping("/loadfilenames")
	//@Scheduled(cron = "0 */5 * ? * *")

	private void saveFileTypes() {
		String[] fileTypesArray = new String[] { FileTypes.files_in.toString(), FileTypes.files_out.toString(),
				FileTypes.errorlog.toString() };
		
		deliveryFilesService.deleteDeliveryFilesOlderThanOneWeek();
		
		for (String fileType : fileTypesArray) {
			DeliveryFileTypes types = new DeliveryFileTypes();
			types.setFileType(fileType);
			types.setFilename(fileType + "_" + dateFormatter.getYesterdayDate() + ".csv");
			deliveryFileTypesService.saveDeliveryFileTypes(types);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/Importfiles")
	@Scheduled(cron = "0 */5 * ? * *")
	public ResponseEntity<String> importCsvToDBJob() {

		DeliveryFileTypes deliveryFileTypes = deliveryFileTypesService.getFilename();

		if (deliveryFileTypes != null && new File(path + deliveryFileTypes.getFilename()).exists()) {

			JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
					.addLong("fileTypeId", deliveryFileTypes.getDeliveryFileId())
					.addString("filename", deliveryFileTypes.getFilename()).toJobParameters();
			try {
				Path temp = Files.move(Paths.get(path + deliveryFileTypes.getFilename().toString()),
						Paths.get(tempFilepath + deliveryFileTypes.getFilename().toString()));

				JobExecution ex = jobLauncher.run(job, jobParameters);

				if (ex.getStatus() == BatchStatus.COMPLETED) {
					File deleteFile= new File(tempFilepath + deliveryFileTypes.getFilename());
					deleteFile.delete();
					logger.info("file deleted " + deleteFile.getName());
					deliveryFileTypesService.deleteDeliveryFileTypes(deliveryFileTypes.getDeliveryFileId());
					
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return new ResponseEntity("Message", HttpStatus.CREATED);
		} else {
			logger.info("No files to load");
			return new ResponseEntity("No files to load!", HttpStatus.OK);
		}
	}
}
package com.bsva.dcqs.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import com.bsva.dcqs.listeners.JobCompletionNotificationListener;
import com.bsva.dcqs.model.DeliveryFiles;

import com.bsva.dcqs.processor.DeliveryFilesProcessor;
import com.bsva.dcqs.repository.DeliveryFilesRepository;

@Configuration // Informs Spring that this class contains configurations
@EnableBatchProcessing // Enables batch processing for the application
//@RequiredArgsConstructor

public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Lazy
	public DeliveryFilesRepository deliveryFilesRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	@StepScope
   
	public FlatFileItemReader<DeliveryFiles> reader(@Value("#{jobParameters[filename]}") final String filename) {

		FlatFileItemReader<DeliveryFiles> reader = new FlatFileItemReader();

		reader.setResource(new FileSystemResource(new File(filename)));

		reader.setLineMapper(new DefaultLineMapper() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter(DELIMITER_COMMA);
						if (!filename.startsWith("error")) {
							setNames("userNo", "processingDate", "processedTime", "serviceType", "subservice",
									"direction", "acked", "recNum", "filename", "filenumber", "ackedTime", "indicator");
						} else {
							
							setNames( "filename","processingDate", "processedTime", "filenumber",
									"subservice","serviceType","direction", "errorCode", "errorText");
						}
					}
				});

				setFieldSetMapper(new BeanWrapperFieldSetMapper() {
					{

						setTargetType(DeliveryFiles.class);

					}
				});
			}
		});
		return reader;
	}

	@Bean
	public DeliveryFilesProcessor processor() {
		return new DeliveryFilesProcessor();
	}

	@Bean
	public RepositoryItemWriter<DeliveryFiles> writer() {
		RepositoryItemWriter<DeliveryFiles> iwriter = new RepositoryItemWriter();
		iwriter.setRepository(deliveryFilesRepository);
		iwriter.setMethodName("save");
		return iwriter;
	}

	@Bean
	public Step step1(ItemReader<DeliveryFiles> itemReader, ItemWriter<DeliveryFiles> itemWriter) throws Exception {

		return this.stepBuilderFactory.get("step1").<DeliveryFiles, DeliveryFiles>chunk(5).reader(itemReader)
				.processor(processor()).writer(itemWriter).build();
	}

	@Bean
	//@PostConstruct
	public Job importCsvFileJob(JobCompletionNotificationListener listener, Step step1) throws Exception {

		return this.jobBuilderFactory.get("importCsvFileJob").incrementer(new RunIdIncrementer()).listener(listener)
				.start(step1).build();
	}
}

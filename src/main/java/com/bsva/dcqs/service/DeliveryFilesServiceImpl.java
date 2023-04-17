package com.bsva.dcqs.service;

import java.time.Instant;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsva.dcqs.model.DeliveryFiles;
import com.bsva.dcqs.repository.DeliveryFilesRepository;

@Service
public class DeliveryFilesServiceImpl implements DeliveryFilesService {

	@Autowired
	private DeliveryFilesRepository deliveryFilesRepository;

	private DeliveryFiles deliveryFiles = new DeliveryFiles();

	public DeliveryFiles getFileDetails(String filename) {
		// TODO Auto-generated method stub
		
			return deliveryFiles = deliveryFilesRepository.findFirstByFilename(filename);
	}

	public String deleteById(long id) {
		// TODO Auto-generated method stub
		deliveryFilesRepository.deleteById(id);
		return "successfully deleted id " + id;
	}

	public void saveDeliveryFile(DeliveryFiles deliveryFiles) {
		// TODO Auto-generated method stub
		deliveryFilesRepository.save(deliveryFiles);
	}

	public void deleteDeliveryFilesOlderThanOneWeek() {
		// TODO Auto-generated method stub
		 Instant xDays = Instant.now().minus(Period.ofDays(7));
		 deliveryFilesRepository.deleteDeliveryFilesOlderThanOneWeek(xDays);
		
	}

	public void deleteByprocessingDate(String date) {
		// TODO Auto-generated method stub
		deliveryFilesRepository.deleteByprocessingDate(date);
	}

}

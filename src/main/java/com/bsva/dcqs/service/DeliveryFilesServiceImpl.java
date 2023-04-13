package com.bsva.dcqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsva.dcqs.model.DeliveryFiles;
import com.bsva.dcqs.repository.DeliveryFilesRepository;

@Service
public class DeliveryFilesServiceImpl implements DeliveryFilesService {
	
	@Autowired
	private DeliveryFilesRepository deliveryFilesRepository;
	
	private  DeliveryFiles deliveryFiles = new DeliveryFiles();
	
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

}

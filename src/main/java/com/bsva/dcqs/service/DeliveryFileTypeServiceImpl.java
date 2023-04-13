package com.bsva.dcqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsva.dcqs.model.DeliveryFileTypes;
import com.bsva.dcqs.model.DeliveryFiles;
import com.bsva.dcqs.repository.DeliveryFileTypesRepository;

@Service
public class DeliveryFileTypeServiceImpl implements DeliveryFileTypesService {
	
	@Autowired
	DeliveryFileTypesRepository deliveryFileTypesRepository;
	
	public void saveDeliveryFileTypes(DeliveryFileTypes deliveryFileTypes)
	{
		deliveryFileTypesRepository.save(deliveryFileTypes);
	}
	
	public void deleteDeliveryFileTypes(long id)
	{
		deliveryFileTypesRepository.deleteById(id);
	}
	
	public DeliveryFileTypes getFilename()
	{
		 DeliveryFileTypes deliveryFileTypes = deliveryFileTypesRepository.findFirstByOrderByFilenameDesc();
		return deliveryFileTypes;
	}

	
	
}

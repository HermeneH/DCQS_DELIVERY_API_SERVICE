package com.bsva.dcqs.service;

import java.time.Instant;

import com.bsva.dcqs.model.DeliveryFiles;

public interface DeliveryFilesService {
	
	public DeliveryFiles getFileDetails(String filename) throws Exception;
	
	public void deleteDeliveryFilesOlderThanOneWeek();
	
	public void deleteByprocessingDate(String date);

}

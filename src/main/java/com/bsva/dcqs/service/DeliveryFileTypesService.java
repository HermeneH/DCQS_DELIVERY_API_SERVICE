package com.bsva.dcqs.service;

import com.bsva.dcqs.model.DeliveryFileTypes;
import com.bsva.dcqs.model.DeliveryFiles;

public interface DeliveryFileTypesService {
	
	public void saveDeliveryFileTypes(DeliveryFileTypes deliveryFileTypes);
	public DeliveryFileTypes getFilename();
	public void deleteDeliveryFileTypes(long id);

}

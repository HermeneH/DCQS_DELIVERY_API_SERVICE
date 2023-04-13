package com.bsva.dcqs.processor;

import java.util.logging.Logger;
import org.springframework.batch.item.ItemProcessor;
import com.bsva.dcqs.model.DeliveryFiles;

public class DeliveryFilesProcessor implements ItemProcessor<DeliveryFiles, DeliveryFiles> {
	
	@Override
    public DeliveryFiles process(final DeliveryFiles deliveryFiles) throws Exception {
		final long deliveryId = deliveryFiles.getDeliveryId();
        final String userNo = deliveryFiles.getUserNo();
        final String processingDate = deliveryFiles.getProcessingDate();
        final String processedTime = deliveryFiles.getProcessedTime();
        final String serviceType = deliveryFiles.getServiceType();
        final String subservice =deliveryFiles.getSubservice();
        final String direction = deliveryFiles.getDirection();
        final String acked = deliveryFiles.getAcked();
        final String recNum = deliveryFiles.getRec_num();
        final String filename = deliveryFiles.getFilename();
        final String filenumber = deliveryFiles.getFilenumber();
        final String ackedTime = deliveryFiles.getAcked_time();
        final String indicator = deliveryFiles.getIndicator();
        final String errorCode = deliveryFiles.getErrorCode();
        final String errorText = deliveryFiles.getErrorText();
        // Creates a new instance of Person
        
        final DeliveryFiles transformedDeliveryFiles = new DeliveryFiles(userNo, processingDate, processedTime, serviceType, subservice, direction, acked, recNum, filename, filenumber, ackedTime, indicator,errorCode,errorText);
        // logs the person entity to the application logs
       // logger.info("Converting (" + customer + ") into (" + transformedCustomer + ")");
        return transformedDeliveryFiles;
    }

}

package com.bsva.dcqs.listeners;

import com.bsva.dcqs.repository.DeliveryFilesRepository;
import com.bsva.dcqs.service.DeliveryFileTypeServiceImpl;
import com.bsva.dcqs.service.DeliveryFilesService;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    @Autowired
	DeliveryFilesService deliveryFileTypeService;
    
    @Autowired
    public JobCompletionNotificationListener(DeliveryFilesService deliveryFileTypeService) {
        this.deliveryFileTypeService = deliveryFileTypeService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
       
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
        	
        	
        	//deliveryFilesRepository.deleteById(id);
        }
    }
}

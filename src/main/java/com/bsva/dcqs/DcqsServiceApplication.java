package com.bsva.dcqs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("com.bsva.dcqs.model")
@EnableScheduling
public class DcqsServiceApplication
{
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
public static void main(String[] args) 
{
SpringApplication.run(DcqsServiceApplication.class, args);
}
}
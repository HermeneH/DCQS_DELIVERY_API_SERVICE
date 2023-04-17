package com.bsva.dcqs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsva.dcqs.enums.FileTypes;
import com.bsva.dcqs.model.DeliveryFileTypes;
import com.bsva.dcqs.model.DeliveryFiles;
import com.bsva.dcqs.service.DeliveryFilesService;
import com.bsva.dcqs.dto.DeliveryFilesResponsePayloadDto;

@RestController
@RequestMapping(path = "/dcqs") // Root path

public class DeliveryDataController {

	@Autowired
	DeliveryFilesService deliveryFilesService;

	// @Autowired
	// private ModelMapper modelMapper;

	@GetMapping("/delivery/{filename}")
	private DeliveryFiles getFileStatus(@PathVariable("filename") String filename) throws Exception {
		DeliveryFiles deliveryFiles = deliveryFilesService.getFileDetails(filename);
		return deliveryFiles;

	}

}

package com.bsva.dcqs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsva.dcqs.model.DeliveryFileTypes;;


public interface DeliveryFileTypesRepository extends JpaRepository<DeliveryFileTypes, Long>{
	
	DeliveryFileTypes findFirstByOrderByFilenameDesc();

}

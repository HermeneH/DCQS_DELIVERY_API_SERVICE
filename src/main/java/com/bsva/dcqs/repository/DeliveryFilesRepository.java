package com.bsva.dcqs.repository;

import com.bsva.dcqs.model.DeliveryFileTypes;
import com.bsva.dcqs.model.DeliveryFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryFilesRepository extends JpaRepository<DeliveryFiles, Long>{
	
	DeliveryFiles findFirstByFilename(String filename);
}

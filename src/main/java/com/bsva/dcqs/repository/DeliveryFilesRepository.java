package com.bsva.dcqs.repository;

import com.bsva.dcqs.model.DeliveryFileTypes;
import com.bsva.dcqs.model.DeliveryFiles;

import java.time.Instant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DeliveryFilesRepository extends JpaRepository<DeliveryFiles, Long> {

	DeliveryFiles findFirstByFilename(String filename);

	@Modifying
	@Transactional
	@Query(value = "delete  from DeliveryFiles where processingDate = :p")
	void deleteByprocessingDate(@Param("p") String date);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM delivery_files del WHERE TO_DATE( del.processing_date, 'YYYY-MM-dd' ) <= :p", nativeQuery = true)
	void deleteDeliveryFilesOlderThanOneWeek(@Param("p") Instant date);

}

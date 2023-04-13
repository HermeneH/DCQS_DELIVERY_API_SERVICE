package com.bsva.dcqs.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DELIVERY_FILES")
public class DeliveryFiles {
	
	  @Id
	 
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Basic(optional = false)
	  //@NotNull
	  @Column(name = "delivery_id")
	  long deliveryId;
	  
	  @Column(name = "user_no")
	  String userNo;
	  
	  @Column(name = "processing_date") 
	  String processingDate;
	   
	  @Column(name = "filename") 
	  String filename;
	  
	  @Column(name = "processed_time")
	  String processedTime;
	 
	  @Column(name = "service_type")
	  String serviceType;
	
	  @Column(name = "subservice")
	  String subservice;
	
	  @Column(name = "direction")
	  String direction;
	
	  @Column(name = "acked")
	  String acked;

	  @Column(name = "recNum")
	  String rec_num;
	  
	  @Column(name = "filenumber")
	  String filenumber;
	  
	  @Column(name = "ackedTime")
	  String acked_time;
	  
	  @Column(name = "indicators")
	  String indicator;
	  
	  @Column(name = "error_code")
	  String errorCode;
	  
	  @Column(name = "error_text")
	  String errorText;
	  
	
	public DeliveryFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryFiles(String userNo, String processingDate, String processedTime, String serviceType,
			String subservice, String direction, String acked, String recNum,
			String filename, String filenumber, String ackedTime,String indicator,String errorCode,String errorText) {
		super();
		//this.deliveryId = deliveryId;
		this.filename = filename;
		this.processingDate = processingDate;
		this.processedTime = processedTime;
		this.userNo = userNo;
		this.serviceType = serviceType;
		this.subservice = subservice;
		this.direction = direction;
		this.acked = acked;
		this.rec_num = recNum;
		this.filenumber = filenumber;
		this.acked_time = ackedTime;
		this.indicator = indicator;
		this.errorCode = errorCode;
		this.errorText = errorText;
	}


	/**
	 * @return the deliveryId
	 */
	public long getDeliveryId() {
		return deliveryId;
	}


	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}


	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}


	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}


	/**
	 * @return the processingDate
	 */
	public String getProcessingDate() {
		return processingDate;
	}


	/**
	 * @param processingDate the processingDate to set
	 */
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}


	/**
	 * @return the processedTime
	 */
	public String getProcessedTime() {
		return processedTime;
	}


	/**
	 * @param processedTime the processedTime to set
	 */
	public void setProcessedTime(String processedTime) {
		this.processedTime = processedTime;
	}


	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}


	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}


	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	/**
	 * @return the subservice
	 */
	public String getSubservice() {
		return subservice;
	}


	/**
	 * @param subservice the subservice to set
	 */
	public void setSubservice(String subservice) {
		this.subservice = subservice;
	}


	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}


	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}


	/**
	 * @return the acked
	 */
	public String getAcked() {
		return acked;
	}


	/**
	 * @param acked the acked to set
	 */
	public void setAcked(String acked) {
		this.acked = acked;
	}


	/**
	 * @return the rec_num
	 */
	public String getRec_num() {
		return rec_num;
	}


	/**
	 * @param rec_num the rec_num to set
	 */
	public void setRec_num(String rec_num) {
		this.rec_num = rec_num;
	}


	/**
	 * @return the filenumber
	 */
	public String getFilenumber() {
		return filenumber;
	}


	/**
	 * @param filenumber the filenumber to set
	 */
	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}


	/**
	 * @return the acked_time
	 */
	public String getAcked_time() {
		return acked_time;
	}


	/**
	 * @param acked_time the acked_time to set
	 */
	public void setAcked_time(String acked_time) {
		this.acked_time = acked_time;
	}


	/**
	 * @return the indicator
	 */
	public String getIndicator() {
		return indicator;
	}


	/**
	 * @param indicator the indicator to set
	 */
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeliveryFiles [deliveryId=" + deliveryId + ", userNo=" + userNo + ", processingDate=" + processingDate
				+ ", filename=" + filename + ", processedTime=" + processedTime + ", serviceType=" + serviceType
				+ ", subservice=" + subservice + ", direction=" + direction + ", acked=" + acked + ", rec_num="
				+ rec_num + ", filenumber=" + filenumber + ", acked_time=" + acked_time + ", indicator=" + indicator
				+ ", errorCode=" + errorCode + ", errorText=" + errorText + "]";
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorText
	 */
	public String getErrorText() {
		return errorText;
	}

	/**
	 * @param errorText the errorText to set
	 */
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	
}

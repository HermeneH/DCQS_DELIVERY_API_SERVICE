package com.bsva.dcqs.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY_FILES_TYPES")
public class DeliveryFileTypes {
	
	  @Id
		 
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Basic(optional = false)
	  //@NotNull
	  @Column(name = "delivery_file_id")
	  long deliveryFileId;
	  
	  @Column(name = "file_type") 
	  String fileType;
	  
      @Column(name = "filename")
      String filename;
      
	public DeliveryFileTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryFileTypes(String fileType, String filename) {
		super();
		this.fileType = fileType;
		this.filename = filename;
	}

	/**
	 * @return the deliveryFileId
	 */
	public long getDeliveryFileId() {
		return deliveryFileId;
	}

	/**
	 * @param deliveryFileId the deliveryFileId to set
	 */
	public void setDeliveryFileId(long deliveryFileId) {
		this.deliveryFileId = deliveryFileId;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeliveryFileTypes [deliveryFileId=" + deliveryFileId + ", fileType=" + fileType + ", filename="
				+ filename + "]";
	}
      
      
}

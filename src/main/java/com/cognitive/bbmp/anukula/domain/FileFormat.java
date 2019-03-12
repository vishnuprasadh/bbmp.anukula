package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fileProcess")
public class FileFormat implements Serializable{
	
	@Id
	@Column(name="_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	@NotNull
	@Column(name="type")
	private String type;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	private static final long serialVersionUID = 1L;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	
	@NotNull
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="dateCreated")
	private String dateCreated;
	
	@Column(name="lastModified")
	private String lastModified;

}

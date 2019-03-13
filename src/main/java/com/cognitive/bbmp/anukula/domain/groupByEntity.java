package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class groupByEntity implements Serializable{

	public groupByEntity(String location, String status, String priority) {
		super();
		this.location = location;
		this.status = status;
		this.priority = priority;
	}
	
	public groupByEntity() {}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Column(name="location")
	private String location;
	@Column(name="status")
	private String status;
	@Column(name="priority")
	private String priority;
	
	
	

}

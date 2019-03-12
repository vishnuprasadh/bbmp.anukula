package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

//@Entity
//@Table
public class User implements Serializable{
	
	
	public User() {}
	
	public User(UUID userId, String emailId, String contactNumber, UUID registrationDate)
	{
		this.userId = userId;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.registrationDate = registrationDate;
	}
	
	private UUID userId;
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UUID getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(UUID registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	private String contactNumber;
	private String emailId;
	private UUID registrationDate;
	
	

}

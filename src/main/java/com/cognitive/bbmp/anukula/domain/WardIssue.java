package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="wardIssue")
public class WardIssue implements Serializable {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private String _id;
	
	@Column(name="issueHistory")
	private List<IssueHistory> issueHistory;
	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getComplaintSource() {
		return complaintSource;
	}

	public void setComplaintSource(String complaintSource) {
		this.complaintSource = complaintSource;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTypeofComplaint() {
		return typeofComplaint;
	}

	public void setTypeofComplaint(String typeofComplaint) {
		this.typeofComplaint = typeofComplaint;
	}

	
	
	@NotNull
	@Column(name="wardCode")
	private String wardCode;
	

	@NotNull
	@Column(name="issueId")
	private String issueId;
	
	@NotNull
	@Column(name="actionTaken")
	private String complaintSource;
	
	@NotNull
	@Column(name="complaintDate")
	private String complaintDate;
	
	@NotNull
	@Column(name="location")
	private String location;
	
	@NotNull
	@Column(name="typeofComplaint")
	private String typeofComplaint;
	
	@Column(name="status")
	private String status;
	
	@Column(name="category")
	private String category;
	
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="dateUpdated")
	private String dateUpdated;
	
	
	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<IssueHistory> getHistory() {
		return issueHistory;
	}

	public void setHistory(List<IssueHistory> issueHistory) {
		this.issueHistory = issueHistory;
	}


}

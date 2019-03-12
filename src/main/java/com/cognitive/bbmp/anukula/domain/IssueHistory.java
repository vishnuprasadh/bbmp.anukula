package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="issueHistory")
public class IssueHistory implements Serializable {

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
	@Id
	@Column(name="_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	
	@Column(name="issueId")
	private String issueId;
	
	@Column(name="actionTaken")
	private String actionTaken;
	
	
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	public String getSiteReport() {
		return siteReport;
	}
	public void setSiteReport(String siteReport) {
		this.siteReport = siteReport;
	}
	public String getStatusComments() {
		return statusComments;
	}
	public void setStatusComments(String statusComments) {
		this.statusComments = statusComments;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	@Column(name="siteReport")
	private String siteReport;
	
	@Column(name="statusComments")
	private String statusComments;
	
	@Column(name="dateUpdated")
	private String dateUpdated;
	
	
}

package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

public class RoadIssue implements Serializable {

	
	private float estimatedLength;
	public float getestimatedLength() {
		return estimatedLength;
	}

	public void setestimatedLength(float estimatedLength) {
		this.estimatedLength = estimatedLength;
	}

	public float getestimatedWidth() {
		return estimatedWidth;
	}

	public void setestimatedWidth(float estimatedWidth) {
		this.estimatedWidth = estimatedWidth;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public UUID getRoadIssueId() {
		return roadIssueId;
	}

	public void setRoadIssueId(UUID roadIssueId) {
		this.roadIssueId = roadIssueId;
	}

	public String getLatId() {
		return latId;
	}

	public void setLatId(String latId) {
		this.latId = latId;
	}

	public String getLongId() {
		return longId;
	}

	public void setLongId(String longId) {
		this.longId = longId;
	}

	public String getAskTitle() {
		return askTitle;
	}

	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}

	public String getAskComments() {
		return askComments;
	}

	public void setAskComments(String askComments) {
		this.askComments = askComments;
	}

	public List<String> getCurrentState() {
		return currentState;
	}

	public void setCurrentState(List<String> currentState) {
		this.currentState = currentState;
	}

	public List<String> getFutureState() {
		return futureState;
	}

	public void setFutureState(List<String> futureState) {
		this.futureState = futureState;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getReportedTime() {
		return reportedTime;
	}

	public void setReportedTime(Date reportedTime) {
		this.reportedTime = reportedTime;
	}

	public List<String> getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(List<String> imageLinks) {
		this.imageLinks = imageLinks;
	}
	
	
	public RoadIssue() {}
	
	public RoadIssue(UUID roadIssueid, String roadId,
			 String userId, @Value("null") List<String> currentState,
			 @Value("null") List<String> futureState,
			 @Value("null") List<String> imageLinks,
			 @Value("${unit.default.length}") String unit, @Value("null") float estimatedWidth, 
			 @Value("null") float estimatedLength, 
			 @Value("") String latId,  @Value("") String longId, 
			 @Value("") String askTitle,
			 @Value("") String askComments )
	{
		this.roadIssueId  = roadIssueid;
		this.roadId = roadId;
		this.userId = userId;
		
		this.currentState = currentState;
		this.futureState = futureState;
		this.imageLinks = imageLinks;
		
		this.unit =unit;
		this.estimatedLength = estimatedLength;
		this.estimatedWidth = estimatedWidth;
		this.latId = latId;
		this.longId = longId;
		this.askTitle = askTitle;
		this.askComments = askComments;
		
	}
	
	
	private String roadId;
	
	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	
	private float estimatedWidth;
	
	private String unit;
	
	private UUID roadIssueId;
	
	private String latId;
	
	private String longId;
	
	private String askTitle;
	
	private String askComments;
	
	private List<String> currentState;
	
	private List<String> futureState;
	
	private String userId;
	
	private Date reportedTime;
	
	private List<String> imageLinks;
	
	
}

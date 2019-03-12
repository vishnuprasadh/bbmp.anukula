package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;

import com.mongodb.lang.Nullable;

public class BothSideStatus implements Serializable {
 
	public BothSideStatus()
	{}
	
	public void setLeftCurrrentState(List<String>  leftCurrrentState) {
		this.leftCurrrentState = leftCurrrentState;
	}
	public List<String>  getRightCurrentState() {
		return rightCurrentState;
	}
	public void setRightCurrentState(List<String>  rightCurrentState) {
		this.rightCurrentState = rightCurrentState;
	}
	public List<String>  getLeftfutureState() {
		return leftfutureState;
	}
	public void setLeftfutureState(List<String>  leftfutureState) {
		this.leftfutureState = leftfutureState;
	}
	public List<String>  getRightfutureState() {
		return rightfutureState;
	}
	public void setRightfutureState(List<String>  rightfutureState) {
		this.rightfutureState = rightfutureState;
	}
	public String getReportedBy() {
		return reportedBy;
	}
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<String> getMapURL() {
		return mapURL;
	}
	public void setMapURL(List<String> mapURL) {
		this.mapURL = mapURL;
	}
	public String getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(String reportedOn) {
		this.reportedOn = reportedOn;
	}
	
	
	public HashMap<String, String> getGeometry() {
		return geometry;
	}
	public void setGeometry(HashMap<String, String> geometry) {
		this.geometry = geometry;
	}
	
	public HashMap<String, String> getMedia() {
		return media;
	}
	public void setMedia(HashMap<String, String> media) {
		this.media = media;
	}

	private List<String>  futureState;
	
	private List<String> leftCurrrentState;
	private List<String>  rightCurrentState;
	private List<String>  leftfutureState;
	private List<String>  rightfutureState;
	
	private String reportedBy;
	private String comments;
	
	@Nullable
	@Column(name="mapurl")
	private List<String> mapURL;
	
	private String reportedOn; 
	
	@Nullable
	@Column(name="geometry")
	private HashMap<String,String> geometry;
	
	@Nullable
	@Column(name="media")
	private HashMap<String, String> media;
	
	@Column(name="streetId")
	private String streetID;
	public String getStreetID() {
		return streetID;
	}

	public void setStreetID(String streetID) {
		this.streetID = streetID;
	}
	
	
}

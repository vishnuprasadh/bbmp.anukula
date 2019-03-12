package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mongodb.lang.Nullable;

@Entity
public class StreetLights implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StreetLights() {
	}
	
	
	@Id
	@Column(name="_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public long getCurrentPoles() {
		return currentPoles;
	}
	public void setCurrentPoles(long currentPoles) {
		this.currentPoles = currentPoles;
	}
	public long getCurrentLights() {
		return currentLights;
	}
	public void setCurrentLights(long currentLights) {
		this.currentLights = currentLights;
	}
	public long getPolesNeed() {
		return polesNeed;
	}
	public void setPolesNeed(long polesNeed) {
		this.polesNeed = polesNeed;
	}
	public long getLightsetNeed() {
		return lightsetNeed;
	}
	public void setLightsetNeed(long lightsetNeed) {
		this.lightsetNeed = lightsetNeed;
	}
	public long getRepairLight() {
		return repairLight;
	}
	public void setRepairLight(long repairLight) {
		this.repairLight = repairLight;
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
	public String getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(String reportedOn) {
		this.reportedOn = reportedOn;
	}
	public List<HashMap<String, String>> getMapURL() {
		return mapURL;
	}
	public void setMapURL(List<HashMap<String, String>> mapURL) {
		this.mapURL = mapURL;
	}
	public List<HashMap<String, String>> getGeometry() {
		return geometry;
	}
	public void setGeometry(List<HashMap<String, String>> geometry) {
		this.geometry = geometry;
	}
	public List<HashMap<String, String>> getMedia() {
		return media;
	}
	public void setMedia(List<HashMap<String, String>> media) {
		this.media = media;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Nullable
	@Column(name="currentPoles")
	private long currentPoles; 
	
	@Nullable
	@Column(name="currentLights")
	private long currentLights;
	
	@Nullable
	@Column(name="polesNeed")
	private long polesNeed;
	
	@Nullable
	@Column(name="lightsetNeed")
	private long lightsetNeed;
	
	@Nullable
	@Column(name="repairLight")
	private long repairLight;
	
	
	@Column(name="reportedBy")
	private String reportedBy;
	@Column(name="comments")
	private String comments;
	@Column(name="reportedOn")
	private String reportedOn; 
	@Nullable
	@Column(name="mapurl")
	private List<HashMap<String, String>> mapURL;
	@Nullable
	@Column(name="geometry")
	private List<HashMap<String,String>> geometry;
	@Nullable
	@Column(name="media")
	private List<HashMap<String, String>> media;
	
	@Column(name="roadId")
	private String roadId;
	
	public String getRoadID() {
		return roadId;
	}

	public void setRoadID(String roadId) {
		this.roadId = roadId;
	}
	
	

}

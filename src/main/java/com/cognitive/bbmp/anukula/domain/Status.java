package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.web.ProjectedPayload;

import com.mongodb.lang.Nullable;


@Entity
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Status()
	{}
	
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

	@Nullable
	@Column(name="currentState")
	private List<String> currentState;
	
		@Nullable
	@Column(name="futureState")
	private List<String>  futureState;
	
	@Nullable
	@Column(name="lcurrentState")
	private List<String> lcurrentState;
	
	@Nullable
	@Column(name="rcurrentState")
	private List<String>  rcurrentState;
	
	@Nullable
	@Column(name="lfutureState")
	private List<String>  lfutureState;
	
	@Nullable
	@Column(name="rfutureState")
	private List<String>  rfutureState;
	
	@Nullable
	@Column(name="reportedBy")
	private String reportedBy;
	
	@Nullable
	@Column(name="comments")
	private String comments;
	
	@Nullable
	@Column(name="reportedOn")
	private String reportedOn; 
	
	@Nullable
	@Column(name="mapurl")
	private List<HashMap<String, String>> mapurl;
	
	
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

	public List<String> getLcurrentState() {
		return lcurrentState;
	}

	public void setLcurrentState(List<String> lcurrentState) {
		this.lcurrentState = lcurrentState;
	}

	public List<String> getRcurrentState() {
		return rcurrentState;
	}

	public void setRcurrentState(List<String> rcurrentState) {
		this.rcurrentState = rcurrentState;
	}

	public List<String> getLfutureState() {
		return lfutureState;
	}

	public void setLfutureState(List<String> lfutureState) {
		this.lfutureState = lfutureState;
	}

	public List<String> getRfutureState() {
		return rfutureState;
	}

	public void setRfutureState(List<String> rfutureState) {
		this.rfutureState = rfutureState;
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

	public List<HashMap<String, String>> getMapurl() {
		return mapurl;
	}

	public void setMapurl(List<HashMap<String, String>> mapurl) {
		this.mapurl = mapurl;
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

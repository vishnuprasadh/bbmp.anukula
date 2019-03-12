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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;


@Document(collection="roads")
public class Roads implements Serializable{

	@Column(name="length")
	private String length;
	@Column(name="width")
	private String width;
	@Column(name="unit")
	private String unit;
	@Column(name="streetType")
	private String streetType;
	
	@Nullable
	@Column(name="attributes")
	private List<HashMap<String, String>> attributes;
	
	@Nullable
	@Column(name="streetName")
	private String streetName;
	
	@Id
	@Column(name="_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	@Column(name="roadId")
	private String roadId;
	
	@Column(name="wardCode")
	private String wardCode;
	
	@Column(name="dateUpdated")
	private String dateUpdated;
	
	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
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

	@Nullable
	@Column(name="reportedBy")
	private String reportedBy;
	
	@Nullable
	@Column(name="comments")
	private String comments;
	
	@Nullable
	@Column(name="reportedOn")
	private String reportedOn; 
	
	
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
	
	public List<HashMap<String, String>> getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(List<HashMap<String, String>> mapUrl) {
		this.mapUrl = mapUrl;
	}

	@Nullable
	@Column(name="media")
	private List<HashMap<String, String>> media;
	
	@Column(name="mapUrl")
	private List<HashMap<String,String>> mapUrl;
	
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public List<HashMap<String, String>> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<HashMap<String, String>> attributes) {
		this.attributes = attributes;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}



	/*public Road(
			String _id,
			String roadId,
			String wardCode , 
			String streetName,
			String streetType,
			String length,
			String width,
			List<HashMap<String,String>> attributes,
			List<Status> roadstate,
			List<Status> drain,
			List<Status> footpaths,
			List<Status> culverts,
			List<StreetLights> streetLights,
			String unit
			)

	{
		this._id = _id;
		this.roadId = roadId;
		this.wardCode = wardCode;
		this.length = length;
		this.width = width;
		this.streetType= streetType;
		this.attributes = attributes;
		this.streetName = streetName;
		this.unit = unit;
		this.roadstate = roadstate;
		this.drain = drain;
		this.footpaths = footpaths;
		this.culverts = culverts;
		this.streetLights = streetLights;
		
				
	}
	*/
	
	
	
}
    

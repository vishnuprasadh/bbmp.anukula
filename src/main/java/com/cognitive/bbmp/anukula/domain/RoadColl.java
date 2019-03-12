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

import net.bytebuddy.dynamic.scaffold.TypeInitializer.Drain;


@Document(collection="roads")
public class RoadColl implements Serializable{

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
	
	@Nullable
	@Column(name="roadstate")
	private List<Status> roadstate;
	
	@Nullable
	@Column(name="drain")
	private List<Status> drain;
	
	@Nullable
	@Column(name="footpaths")
	private List<Status> footpaths;
	
	@Nullable
	@Column(name="culverts")
	private List<Status> culverts;
	

	@Nullable
	@Column(name="streetLights")
	private List<StreetLights> streetLights;
	
	
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

	public List<Status> getRoadstate() {
		return roadstate;
	}

	public void setRoadstate(List<Status> roadstate) {
		this.roadstate = roadstate;
	}

	public List<Status> getDrain() {
		return drain;
	}

	public void setDrain(List<Status> drain) {
		this.drain = drain;
	}

	public List<Status> getFootpaths() {
		return footpaths;
	}

	public void setFootpaths(List<Status> footpaths) {
		this.footpaths = footpaths;
	}

	public List<Status> getCulverts() {
		return culverts;
	}

	public void setCulverts(List<Status> culverts) {
		this.culverts = culverts;
	}

	public List<StreetLights> getStreetLights() {
		return streetLights;
	}

	public void setStreetLights(List<StreetLights> streetLights) {
		this.streetLights = streetLights;
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
    

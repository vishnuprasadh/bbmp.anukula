package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

@Document("zones")
public class Zone implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<Ward> getWards() {
		return wards;
	}

	public void setWards(List<Ward> wards) {
		this.wards = wards;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Column(name="wards")
	private List<Ward> wards;
	
	@Nullable
	@Column(name="population")
	private long population;
	
	@Column(name="area")
	private String area;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="zoneCode")
	private String zoneCode;
	
	@Column(name="zoneName")
	public String zoneName;


	@Column(name="cityCode")
	public String cityCode;
	
	
	public Zone() {}
	
	public Zone(String _id,String zoneCode, String cityCode, String zoneName,
			 long population,  String area,String unit, List<Ward> ward )
	{
		this._id = _id;
		this.zoneName = zoneName;
		this.cityCode = cityCode;
		this.population = population;
		this.zoneCode = zoneCode;
		this.area = area;
		this.unit= unit;

	}
	


}

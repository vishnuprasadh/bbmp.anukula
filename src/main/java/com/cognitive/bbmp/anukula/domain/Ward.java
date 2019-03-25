package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class Ward implements Serializable{
	
	public Ward() {}
	
	public Ward(String wardCode, String wardId,
			String wardName, String area ,long population, String unit)
	{
		this.area = area;
		this.wardId = wardId;
		this.unit = unit;
		this.wardName = wardName;
		this.wardCode = wardCode;
		this.population = population;
	}
	
	private String wardCode;
	public String getWardCode() {
		return wardCode;
	}
	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
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
	private String wardName;
	private long population;
	private String area;
	private String unit;
	
	private String wardId;
	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}
	
	

}

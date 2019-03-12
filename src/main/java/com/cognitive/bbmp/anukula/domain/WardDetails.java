package com.cognitive.bbmp.anukula.domain;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;

public class WardDetails {
	
	public WardDetails(){
		
		
	}

	private String wardCode;
	
	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public WardDetails(String wardCode,
		long population, String size, HashMap<String, String> wardAttributes, @Value("${areaunit}") String sizeUnit)
	{
		this.population = population;
		this.size = size;
		this.wardAttributes = wardAttributes;
		this.sizeUnit = sizeUnit;
		this.wardCode = wardCode;
		
	}

	
	private String size;
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSizeUnit() {
		return sizeUnit;
	}

	public void setSizeUnit(String sizeUnit) {
		this.sizeUnit = sizeUnit;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}



	private String sizeUnit;
	
	private long population;
	
	private HashMap<String, String> wardAttributes;

	public HashMap<String, String> getAttributes() {
		return wardAttributes;
	}

	public void setAttributes(HashMap<String, String> wardAttributes) {
		this.wardAttributes = wardAttributes;
	}

}

package com.cognitive.bbmp.anukula.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class State implements Serializable {
	
	
	private String stateCode;
	public String getstateCode() {
		return stateCode;
	}

	public void setstateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	private String stateName;
	
	public State() {}
	
	public State(String stateCode, String stateName, List<City> cities )
	{
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.cities = cities;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cities")
	private List<City> cities;
	
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}

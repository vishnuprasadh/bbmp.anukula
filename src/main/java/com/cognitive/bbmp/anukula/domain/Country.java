package com.cognitive.bbmp.anukula.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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


@Document(collection="countries")
public class Country  {

	@Id
	@Column(name="_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String _id;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	private String countryName;
	
	public String get_id() {
		return _id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void set_id(String _id) {
		this._id = _id;
	}


	private String countryCode;
	
	public Country() {}
	
	public Country( String countryCode,  String countryName, List<State> states)
	{
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.states = states;
	}
	
	
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}


	@OneToMany(mappedBy="states", fetch=FetchType.LAZY)
	private List<State> states;
	
	
	
}

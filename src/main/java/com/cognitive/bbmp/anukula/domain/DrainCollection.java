package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class DrainCollection implements Serializable{
	
	@Column(name="drains")
	private List<Status> drains;

	
	public List<Status> getRoads() {
		return drains;
	}

	public void setRoads(List<Status> drains) {
		this.drains = drains;
	}
	

}

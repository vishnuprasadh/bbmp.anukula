package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class FootPathCollection implements Serializable{
	
	@Column(name="footpaths")
	private List<Status> footpaths;

	
	public List<Status> getRoads() {
		return footpaths;
	}

	public void setRoads(List<Status> roads) {
		this.footpaths = roads;
	}
	

}

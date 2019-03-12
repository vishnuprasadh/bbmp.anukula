package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class RoadStateCollection implements Serializable{
	
	@Column(name="roadState")
	private List<Status> roads;

	
	public List<Status> getRoads() {
		return roads;
	}

	public void setRoads(List<Status> roads) {
		this.roads = roads;
	}
	

}

package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class RoadCollection implements Serializable {

	@Column(name="roads")
	private List<Roads> roads;
	
	public RoadCollection() {}
	
	public RoadCollection(List<Roads> roads)
	{
		this.roads = roads;
	}

	public List<Roads> getRoads() {
		return roads;
	}

	public void setRoads(List<Roads> roads) {
		this.roads = roads;
	}
	
	
}

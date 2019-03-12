
package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class StreetLightCollection implements Serializable{
	
	@Column(name="streetlight")
	private List<StreetLights> streetlights;

	
	public List<StreetLights> getRoads() {
		return streetlights;
	}

	public void setRoads(List<StreetLights> streetlights) {
		this.streetlights = streetlights;
	}
	

}

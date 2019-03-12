
package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class CulvertCollection implements Serializable{
	
	@Column(name="culverts")
	private List<Status> culverts;

	
	public List<Status> getRoads() {
		return culverts;
	}

	public void setRoads(List<Status> culverts) {
		this.culverts = culverts;
	}
	

}

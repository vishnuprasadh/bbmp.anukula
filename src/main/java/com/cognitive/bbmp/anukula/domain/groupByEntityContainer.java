package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class groupByEntityContainer implements Serializable {

	@Column(name="_id")
	@JsonProperty("_id")
	private groupByEntity _id;
	
	public groupByEntityContainer() {}
	
	public groupByEntityContainer(groupByEntity _id, String count) {
		super();
		this._id = _id;
		this.count = count;
	}
	public groupByEntity get_id() {
		return _id;
	}
	public void set_id(groupByEntity _id) {
		this._id = _id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	@Column(name="count")
	@JsonProperty("count")
	private String count;
	
	
}

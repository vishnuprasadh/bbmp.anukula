package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class groupByLocation implements Serializable{

	@Column(name="_id")
	private String _id;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	@Column(name="count")
	private String count;
	
	public groupByLocation() {}
	
	public groupByLocation(String id,String count)
	{
		this._id = id;
		this.count = count;
		
	}
	
}

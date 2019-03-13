package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueSnapshot implements Serializable{

	
	public List<groupByLocation> getBylocation() {
		return bylocation;
	}
	public void setBylocation(List<groupByLocation> bylocation) {
		this.bylocation = bylocation;
	}
	public List<groupByEntityContainer> getBypriority() {
		return bypriority;
	}
	public void setBypriority(List<groupByEntityContainer> bypriority) {
		this.bypriority = bypriority;
	}
	public List<groupByEntityContainer> getBystatus() {
		return bystatus;
	}
	public void setBystatus(List<groupByEntityContainer> bystatus) {
		this.bystatus = bystatus;
	}
	
	public IssueSnapshot() {}
	
	public IssueSnapshot(List<groupByLocation> bylocation, List<groupByEntityContainer> bypriority,
			List<groupByEntityContainer> bystatus) {
		super();
		this.bylocation = bylocation;
		this.bypriority = bypriority;
		this.bystatus = bystatus;
	}
	
	@Column(name="bylocation")
	@JsonProperty("bylocation")
	private  List<groupByLocation> bylocation;
	
	@Column(name="bypriority")
	@JsonProperty("bypriority")
	private  List<groupByEntityContainer> bypriority;
	
	@Column(name="bystatus")
	@JsonProperty("bystatus")
	private  List<groupByEntityContainer> bystatus;
	
}

package com.cognitive.bbmp.anukula.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;


@Document("test")
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Nullable
	@Column(name="attribuites")
	private List<HashMap<String, String>> attributes;

	public List<HashMap<String, String>> getAttributes() {
		return attributes;
	}

	public void setAttributes(List< HashMap<String, String>> attributes) {
		this.attributes = attributes;
	}
	
	public Status getStatus()
	{
		List<String> cstate = new ArrayList<String>();
		cstate.add("new");
		
		Status state = new Status();
		state.setCurrentState ( cstate);
		
		state.setFutureState (cstate ) ;
		
		List<HashMap<String, String>> cmap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map  = new HashMap<String,String>();
		map.put("url1","http://localhost:8080");
		cmap.add(map);
		state.setMapurl ( cmap);
		
		
		state.setComments("Nothing");
		state.setReportedBy("Vishnu");
		
		return state;
	}
	

}

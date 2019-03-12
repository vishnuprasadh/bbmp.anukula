package com.cognitive.bbmp.anukula;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognitive.bbmp.anukula.domain.Culverts;
import com.cognitive.bbmp.anukula.domain.Drains;
import com.cognitive.bbmp.anukula.domain.FootPaths;
import com.cognitive.bbmp.anukula.domain.RoadState;
import com.cognitive.bbmp.anukula.domain.Roads;
import com.cognitive.bbmp.anukula.domain.StreetLights;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	String BASEURL = "http://localhost:8080/";
	
	@Test
	public void createRoadState() throws JsonProcessingException {
		RoadState state = new RoadState();
		
		List<String> cstate = new ArrayList<String>();
		cstate.add("Earthen");
		List<String> fstate = new ArrayList<String>();
		fstate.add("Concrete");
		
		//state.set_id("0WKEWJF93939939");
		state.setRoadID("W101");
		state.setCurrentState(cstate);
		state.setFutureState(fstate);
		state.setComments("This is road state sample");
		state.setMapurl(null);
		state.setGeometry(null);
		state.setReportedBy("Vishnu");
		state.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString() );
		
		String serializied = new ObjectMapper().writeValueAsString(state);
		
		System.out.println(serializied);
		
		/*RestAssured.baseURI = BASEURL;
		RequestSpecification request = RestAssured.given();
		request.header(new Header("content-type", "application/json"));
		request.body(serializied);
		
		Response response = request.post("/roadstate/update");
		
		System.out.println(response.asString());
		*/
		
	}
	
	
	@Test
	public void createFootPaths() throws JsonProcessingException {
		FootPaths state = new FootPaths();
		
		List<String> rcurrentstate = new ArrayList<String>();
		rcurrentstate.add("Earthen");
		List<String> lcurrentstate = new ArrayList<String>();
		lcurrentstate.add("Earthen");
		List<String> rfuturetstate = new ArrayList<String>();
		rfuturetstate.add("Concrete");
		List<String> lfuturestate = new ArrayList<String>();
		lfuturestate.add("Concrete");
		
		//state.set_id("0WKEWJF93939939");
		state.setRoadID("W101");
		state.setLcurrentState(lcurrentstate);
		state.setLfutureState(lfuturestate);
		state.setRcurrentState(rcurrentstate);
		state.setRfutureState(rfuturetstate);
		
		state.setComments("This is footpath sample");
		state.setMapurl(null);
		state.setGeometry(null);
		state.setReportedBy("Vishnu");
		state.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString() );
		
		String serializied = new ObjectMapper().writeValueAsString(state);
		
		System.out.println(serializied);
		
		/*RestAssured.baseURI = BASEURL;
		RequestSpecification request = RestAssured.given();
		request.header(new Header("content-type", "application/json"));
		request.body(serializied);
		
		Response response = request.post("/roadstate/update");
		
		System.out.println(response.asString());
		*/
		
	}
	
	@Test
	public void createDrains() throws JsonProcessingException {
		Drains state = new Drains();
		
		List<String> rcurrentstate = new ArrayList<String>();
		rcurrentstate.add("Slab/SS");
		List<String> lcurrentstate = new ArrayList<String>();
		lcurrentstate.add("Slab/SS");
		List<String> rfuturetstate = new ArrayList<String>();
		rfuturetstate.add("Preventive Maintenance");
		List<String> lfuturestate = new ArrayList<String>();
		lfuturestate.add("Preventive Maintenance");
		
		//state.set_id("0WKEWJF93939939");
		state.setRoadID("W101");
		state.setLcurrentState(lcurrentstate);
		state.setLfutureState(lfuturestate);
		state.setRcurrentState(rcurrentstate);
		state.setRfutureState(rfuturetstate);
		
		state.setComments("This is drain sample, need preventive mnce only");
		state.setMapurl(null);
		state.setGeometry(null);
		state.setReportedBy("Vishnu");
		state.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString() );
		
		String serializied = new ObjectMapper().writeValueAsString(state);
		
		System.out.println(serializied);
		
		/*RestAssured.baseURI = BASEURL;
		RequestSpecification request = RestAssured.given();
		request.header(new Header("content-type", "application/json"));
		request.body(serializied);
		
		Response response = request.post("/roadstate/update");
		
		System.out.println(response.asString());
		*/
		
	}
	
	
	@Test
	public void createStreetlights() throws JsonProcessingException {
		StreetLights state = new StreetLights();
		
		
		
		//state.set_id("0WKEWJF93939939");
		state.setRoadID("W101");
		state.setCurrentLights(5);
		state.setCurrentPoles(5);
		state.setLightsetNeed(3);
		state.setPolesNeed(2);
		state.setRepairLight(1);
		state.setComments("This is sample for streetlights, need new lights and repair works");
		state.setMapURL(null);
		state.setGeometry(null);
		state.setReportedBy("Vishnu");
		state.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString() );
		
		String serializied = new ObjectMapper().writeValueAsString(state);
		
		System.out.println(serializied);
		
		/*RestAssured.baseURI = BASEURL;
		RequestSpecification request = RestAssured.given();
		request.header(new Header("content-type", "application/json"));
		request.body(serializied);
		
		Response response = request.post("/roadstate/update");
		
		System.out.println(response.asString());
		*/
		
	}
	
	@Test
	public void createCulverts() throws JsonProcessingException {
		Culverts state = new Culverts();
		
		List<String> cstate = new ArrayList<String>();
		cstate.add("1");
		List<String> fstate = new ArrayList<String>();
		fstate.add("2");
		
		List<HashMap<String, String>> medialist = new ArrayList<HashMap<String,String>>();
		HashMap< String, String> imgmedia = new HashMap<String, String>();
		imgmedia.put("image1", "https://img.com/abc.jpg");
		HashMap< String, String> videomedia = new HashMap<String, String>();
		imgmedia.put("video1", "https://img.com/abc.mp4");
		
		medialist.add(imgmedia);
		medialist.add(videomedia);
		
		//state.set_id("0WKEWJF93939939");
		state.setRoadID("W101");
		state.setCurrentState(cstate);
		state.setFutureState(fstate);
		state.setComments("This is sample for culverts");
		state.setMapurl(null);
		state.setGeometry(null);
		state.setMedia(medialist);
		state.setReportedBy("Vishnu");
		state.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString() );
		
		String serializied = new ObjectMapper().writeValueAsString(state);
		
		System.out.println(serializied);
		
		/*RestAssured.baseURI = BASEURL;
		RequestSpecification request = RestAssured.given();
		request.header(new Header("content-type", "application/json"));
		request.body(serializied);
		
		Response response = request.post("/roadstate/update");
		
		System.out.println(response.asString());
		*/
		
	}
	
	@Test
	public void createRoad() throws JsonProcessingException {
		Roads state = new Roads();
		
		List<HashMap<String, String>> attr = new ArrayList<HashMap<String,String>>();
		
		HashMap< String, String> hash = new HashMap<String, String>();
		List<String> cstate = new ArrayList<String>();
		cstate.add("1");
		List<String> fstate = new ArrayList<String>();
		fstate.add("2");
		
		hash.put("traffic", "Critical");
		hash.put("pcupeak", "300000");
		
		attr.add(hash);
		
		//state.set_id("0WKEWJF93939939");
		state.setRoadId("W101");
		state.setLength("100");
		state.setWidth("200.939");
		state.setUnit("mtr");
		state.setWardCode("BELL");
		state.setStreetName("1st cross");
		state.setStreetType("Intermediary");
		state.setAttributes(attr);
		state.setMapUrl(null);
		state.setGeometry(null);
		state.setMedia(null);
		state.setReportedBy("Vishnu");
		state.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString() );
		state.setComments("This is sample for roads");
		String serializied = new ObjectMapper().writeValueAsString(state);
		
		System.out.println(serializied);
		
		/*RestAssured.baseURI = BASEURL;
		RequestSpecification request = RestAssured.given();
		request.header(new Header("content-type", "application/json"));
		request.body(serializied);
		
		Response response = request.post("/roadstate/update");
		
		System.out.println(response.asString());
		*/
		
	}

}

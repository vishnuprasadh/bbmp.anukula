package com.cognitive.bbmp.anukula.services;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.dialect.Dialect;
import org.hibernate.sql.Insert;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.RoadColl;
import com.cognitive.bbmp.anukula.domain.Roads;
import com.cognitive.bbmp.anukula.domain.Status;
import com.cognitive.bbmp.anukula.domain.StreetLights;
import com.cognitive.bbmp.anukula.domain.Test;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/road")
public class RoadService {

	MongoConfiguration config;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET )
	public ResponseEntity< ?> getRoadState(@PathVariable(name="id") String roadId )
	{
		config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("roadId").is(roadId) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<RoadColl> roads = ops.find(query, RoadColl.class);
		
		return new ResponseEntity<List<RoadColl>>(roads,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST )
	public ResponseEntity<?> createRoad(@RequestBody Roads road )
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		if (road.get_id()!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(road.get_id()));
			//ops.save(road,"roads")
			Update upd = new Update();
			upd.set("attributes", road.getAttributes());
			upd.set("streetname", road.getStreetName());
			upd.set("streetType",road.getStreetType());
			upd.set("length", road.getLength());
			upd.set("wardCode",road.getWardCode());
			upd.set("unit", road.getUnit());
			upd.set("width",road.getWidth());
			upd.set("roadId", road.getRoadId());
			upd.set("mapUrl",road.getMapUrl());
			upd.set("geometry",road.getMapUrl());
			upd.set("media",road.getMapUrl());
			upd.set("reportedBy", road.getReportedBy());
			upd.set("comments", road.getComments());
			upd.set("dateUpdated",new Timestamp(new java.util.Date().getTime()).toString());
			UpdateResult result = ops.upsert(query, upd, "roads");
			long updatedCount = result.getMatchedCount();
			return new ResponseEntity<>(updatedCount, HttpStatus.OK);
		}
		else
		{
			Roads result = ops.insert (road, "roads");
			return new ResponseEntity<>(result.get_id(),HttpStatus.OK);
		}
			
	}
	
	@Deprecated
	@RequestMapping(value="/update/road/{id}", method=RequestMethod.POST )
	public ResponseEntity<?> updateRoadState(@RequestBody Status roadstate , @PathVariable(name="id") String streetId )
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		
		roadstate.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString());
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(streetId));
		
		Update upd = new Update();
		upd.push("roadstate", roadstate);
		UpdateResult update = ops.updateFirst(query, upd, "roads");
		
		
		return new ResponseEntity<Boolean>(update.wasAcknowledged(), HttpStatus.OK);
		
		
	}
	
	
	@Deprecated
	@RequestMapping(value="/update/drain/{id}", method=RequestMethod.POST )
	public ResponseEntity<?> updateDrainState(@RequestBody Status drainState , @PathVariable(name="id") String streetId )
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		
		drainState.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString());
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(streetId));
		
			
		Update upd = new Update();
		upd.push("drain", drainState);
		UpdateResult update = ops.updateFirst(query, upd, "roads");
		
		return new ResponseEntity<Boolean>(update.wasAcknowledged(), HttpStatus.OK);
		
	}
	
	@Deprecated
	@RequestMapping(value="/update/footpath/{id}", method=RequestMethod.POST )
	public ResponseEntity<?> updateFootPath(@RequestBody Status footpathState , 
			@PathVariable(name="id") String streetId )
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		footpathState.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString());
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(streetId));
		
		Update upd = new Update();
		upd.push("footpaths", footpathState);
		UpdateResult update = ops.updateFirst(query, upd, "roads");
		
		return new ResponseEntity<Boolean>(update.wasAcknowledged(), HttpStatus.OK);
		
	}
	
	@Deprecated
	@RequestMapping(value="/update/culvert/{id}", method=RequestMethod.POST )
	public ResponseEntity<?> updateCulvert(@RequestBody Status culvert , 
			@PathVariable(name="id") String streetId )
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(streetId));
		culvert.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString());
		
		
		Update upd = new Update();
		upd.push("culverts", culvert);
		UpdateResult update = ops.updateFirst(query, upd, "roads");
		
		return new ResponseEntity<Boolean>(update.wasAcknowledged(), HttpStatus.OK);
		
		
	}
	
	
	@Deprecated
	@RequestMapping(value="/update/streetlight/{id}", method=RequestMethod.POST )
	public ResponseEntity<?> updateStreetLight(@RequestBody StreetLights streetLight , @PathVariable(name="id") String id )
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		streetLight.setReportedOn( new Timestamp(new java.util.Date().getTime()).toString());
		
		
		Update upd = new Update();
		upd.push("streetLights", streetLight);
		UpdateResult update = ops.updateFirst(query, upd, "roads");
		
		return new ResponseEntity<Boolean>(update.wasAcknowledged(), HttpStatus.OK);
		
	}
	
	@Deprecated
	@RequestMapping(value="/test")
	public ResponseEntity<?> sendStatus()
	{
		Test t = new Test();
		return new ResponseEntity<Status>(t.getStatus(),HttpStatus.OK);
		
	}
	
}

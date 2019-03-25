package com.cognitive.bbmp.anukula.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.Culverts;

import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/culverts")
public class CulvertService {

	@Autowired
	MongoConfiguration config ;
	
	@RequestMapping(name="/update",method=RequestMethod.POST)
	public ResponseEntity<?> updateCulvert(@RequestBody Culverts culvert)
	{
		//config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		if (culvert.get_id()!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("roadId").is(culvert.get_id()));
			
			Update upd = new Update();
			upd.set("comments", culvert.getComments() );
			upd.set("currentState", culvert.getCurrentState());
			upd.set("futureState",culvert.getFutureState());
			upd.set("mapurl", culvert.getMapurl());
			upd.set("geometry",culvert.getGeometry());
			upd.set("media", culvert.getMedia());
			upd.set("reportedBy", culvert.getReportedBy());
			upd.set("roadId", culvert.getRoadID());
			upd.addToSet("reportedOn", new Timestamp(new java.util.Date().getTime()));
			
			UpdateResult result = ops.upsert(query, upd, "culverts");
			long updatedCount = result.getMatchedCount();
			return new ResponseEntity<>(updatedCount, HttpStatus.OK);
		}
		else
		{
			if (culvert.getReportedOn()==null) 
				culvert.setReportedOn(  new Timestamp(new java.util.Date().getTime()).toString());
			Culverts result = ops.insert (culvert, "culverts");
			return new ResponseEntity<>(result.get_id(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<?> getCulvertByIdentifier(@PathVariable(name="id") String id)
	{
		//config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<Culverts> culverts = ops.find(query, Culverts.class);
		
		return new ResponseEntity<List<Culverts>>(culverts,HttpStatus.OK);
	}
	
	@RequestMapping("/roadid/{id}")
	public ResponseEntity<?> getCulvertByRoadId(@PathVariable(name="id") String id)
	{
		//config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("roadid").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<Culverts> culverts = ops.find(query, Culverts.class);
		
		return new ResponseEntity<List<Culverts>>(culverts,HttpStatus.OK);
	}
	
	
}

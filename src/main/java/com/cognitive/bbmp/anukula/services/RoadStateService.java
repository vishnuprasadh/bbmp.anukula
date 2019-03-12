package com.cognitive.bbmp.anukula.services;

import java.sql.Timestamp;
import java.util.List;

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
import com.cognitive.bbmp.anukula.domain.RoadState;
import com.mongodb.client.result.UpdateResult;


@RestController
@RequestMapping("/roadstate")
public class RoadStateService {

	MongoConfiguration config ;
	
	@RequestMapping(name="/update",method=RequestMethod.POST)
	public ResponseEntity<?> updateRoadState(@RequestBody RoadState roadstate)
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		if (roadstate.get_id()!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("roadId").is(roadstate.get_id ()));
			//ops.save(road,"roads")
			Update upd = new Update();
			upd.set("comments", roadstate.getComments() );
			upd.set("currentState", roadstate.getCurrentState());
			upd.set("futureState",roadstate.getFutureState());
			upd.set("mapurl", roadstate.getMapurl());
			upd.set("geometry",roadstate.getGeometry());
			upd.set("media", roadstate.getMedia());
			upd.set("reportedBy", roadstate.getReportedBy());
			upd.set("roadId", roadstate.getRoadID());
			upd.addToSet("reportedOn", new Timestamp(new java.util.Date().getTime()));
			
			UpdateResult result = ops.upsert(query, upd, "roadState");
			long updatedCount = result.getMatchedCount();
			return new ResponseEntity<>(updatedCount, HttpStatus.OK);
		}
		else
		{
			if (roadstate.getReportedOn()==null) 
				roadstate.setReportedOn(  new Timestamp(new java.util.Date().getTime()).toString());
			
			RoadState result = ops.insert (roadstate, "roadState");
			return new ResponseEntity<>(result.get_id(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<?> getRoadStateByIdentifier(@PathVariable(name="id") String id)
	{
		config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<RoadState> roadstate = ops.find(query, RoadState.class);
		
		return new ResponseEntity<List<RoadState>>(roadstate,HttpStatus.OK);
	}
	
	@RequestMapping("/roadid/{id}")
	public ResponseEntity<?> getRoadStateByRoadId(@PathVariable(name="id") String id)
	{
		config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("roadid").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<RoadState> roadstate = ops.find(query, RoadState.class);
		
		return new ResponseEntity<List<RoadState>>(roadstate,HttpStatus.OK);	
	}
	
}

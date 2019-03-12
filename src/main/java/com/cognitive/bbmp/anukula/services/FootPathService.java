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

import com.cognitive.bbmp.anukula.domain.FootPaths;
import com.mongodb.client.result.UpdateResult;


@RestController
@RequestMapping("/footpaths")
public class FootPathService {
	
	
	MongoConfiguration config ;
	
	@RequestMapping(name="/update",method=RequestMethod.POST)
	public ResponseEntity<?> updateFootPath(@RequestBody FootPaths footpaths)
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		if (footpaths.get_id()!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("roadId").is(footpaths.get_id ()));
			//ops.save(road,"roads")
			Update upd = new Update();
			upd.set("comments", footpaths.getComments() );
			upd.set("lcurrentState", footpaths.getLcurrentState());
			upd.set("lfutureState", footpaths.getLfutureState());
			upd.set("rcurrentState",footpaths.getRcurrentState());
			upd.set("rfutureState", footpaths.getRfutureState());
			upd.set("mapurl", footpaths.getMapurl());
			upd.set("geometry",footpaths.getGeometry());
			upd.set("media", footpaths.getMedia());
			upd.set("reportedBy", footpaths.getReportedBy());
			upd.set("roadId", footpaths.getRoadID());
			upd.addToSet("reportedOn", new Timestamp(new java.util.Date().getTime()));
			
			UpdateResult result = ops.upsert(query, upd, "footpaths");
			long updatedCount = result.getMatchedCount();
			return new ResponseEntity<>(updatedCount, HttpStatus.OK);
		}
		else
		{
			if (footpaths.getReportedOn()==null) 
				footpaths.setReportedOn(  new Timestamp(new java.util.Date().getTime()).toString());
			
			FootPaths result = ops.insert (footpaths, "footpaths");
			return new ResponseEntity<>(result.get_id(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<?> getFootPathByIdentifier(@PathVariable(name="id") String id)
	{
		config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<FootPaths> footpaths = ops.find(query, FootPaths.class);
		
		return new ResponseEntity<List<FootPaths>>(footpaths,HttpStatus.OK);
	}
	
	@RequestMapping("/roadid/{id}")
	public ResponseEntity<?> getFootPathtByRoadId(@PathVariable(name="id") String id)
	{
		config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("roadid").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<FootPaths> footpaths = ops.find(query, FootPaths.class);
		
		return new ResponseEntity<List<FootPaths>>(footpaths,HttpStatus.OK);	
	}

}

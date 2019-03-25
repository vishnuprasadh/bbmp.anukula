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
import com.cognitive.bbmp.anukula.domain.Drains;
import com.cognitive.bbmp.anukula.domain.RoadState;
import com.mongodb.client.result.UpdateResult;


@RestController
@RequestMapping("/drains")
public class DrainService {
	
	@Autowired 
	MongoConfiguration config ;
	
	@RequestMapping(name="/update",method=RequestMethod.POST)
	public ResponseEntity<?> updateDrain(@RequestBody Drains drains)
	{
		//config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		if (drains.get_id()!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("roadId").is(drains.get_id ()));
			//ops.save(road,"roads")
			Update upd = new Update();
			upd.set("comments", drains.getComments() );
			upd.set("lcurrentState", drains.getLcurrentState());
			upd.set("lfutureState", drains.getLfutureState());
			upd.set("rcurrentState",drains.getRcurrentState());
			upd.set("rfutureState", drains.getRfutureState());
			upd.set("mapurl", drains.getMapurl());
			upd.set("geometry",drains.getGeometry());
			upd.set("media", drains.getMedia());
			upd.set("reportedBy", drains.getReportedBy());
			upd.set("roadId", drains.getRoadID());
			upd.addToSet("reportedOn", new Timestamp(new java.util.Date().getTime()));
			
			UpdateResult result = ops.upsert(query, upd, "drains");
			long updatedCount = result.getMatchedCount();
			return new ResponseEntity<>(updatedCount, HttpStatus.OK);
		}
		else
		{
			if (drains.getReportedOn()==null) 
				drains.setReportedOn(  new Timestamp(new java.util.Date().getTime()).toString());
			
			Drains result = ops.insert (drains, "drains");
			return new ResponseEntity<String>(result.get_id(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<?> getDrainByIdentifier(@PathVariable(name="id") String id)
	{
		//config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<Drains> drains = ops.find(query, Drains.class);
		
		return new ResponseEntity<List<Drains>>(drains,HttpStatus.OK);
	}
	
	@RequestMapping("/roadid/{id}")
	public ResponseEntity<?> getDrainByRoadId(@PathVariable(name="id") String id)
	{
		//config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("roadid").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<Drains> drains = ops.find(query, Drains.class);
		
		return new ResponseEntity<List<Drains>>(drains,HttpStatus.OK);	
	}

}

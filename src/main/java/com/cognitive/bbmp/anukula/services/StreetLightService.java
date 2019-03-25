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
import com.cognitive.bbmp.anukula.domain.StreetLights;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/streetlights")
public class StreetLightService {

	@Autowired
	MongoConfiguration config ;
	
	@RequestMapping(name="/update",method=RequestMethod.POST)
	public ResponseEntity<?> updateStreetLight(@RequestBody StreetLights streetlights)
	{
		//config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		if (streetlights.get_id()!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("roadId").is(streetlights.get_id ()));
			//ops.save(road,"roads")
			Update upd = new Update();
			upd.set("comments", streetlights.getComments() );
			upd.set("currentLights", streetlights.getCurrentLights() );
			upd.set("currentPoles", streetlights.getCurrentPoles());
			upd.set("lightsetNeed",streetlights.getLightsetNeed());
			upd.set("polesNeed", streetlights.getPolesNeed());
			upd.set("repairLight", streetlights.getRepairLight());
			upd.set("mapurl", streetlights.getMapURL());
			upd.set("geometry",streetlights.getGeometry());
			upd.set("media", streetlights.getMedia());
			upd.set("reportedBy", streetlights.getReportedBy());
			upd.set("roadId", streetlights.getRoadID());
			upd.addToSet("reportedOn", new Timestamp(new java.util.Date().getTime()));
			
			UpdateResult result = ops.upsert(query, upd, "streetlights");
			long updatedCount = result.getMatchedCount();
			return new ResponseEntity<>(updatedCount, HttpStatus.OK);
		}
		else
		{
			if (streetlights.getReportedOn()==null) 
				streetlights.setReportedOn(  new Timestamp(new java.util.Date().getTime()).toString());
			
			StreetLights result = ops.insert (streetlights, "streetlights");
			return new ResponseEntity<>(result.get_id(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<?> getStreetLightByIdentifier(@PathVariable(name="id") String id)
	{
		//config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<StreetLights> streetlights = ops.find(query, StreetLights.class);
		
		return new ResponseEntity<List<StreetLights>>(streetlights,HttpStatus.OK);
	}
	
	@RequestMapping("/roadid/{id}")
	public ResponseEntity<?> getStreetLightByRoadId(@PathVariable(name="id") String id)
	{
		//config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("roadid").is(id) );
		
		MongoOperations ops = config.mongoTemplate();
		
		
		List<StreetLights> streetlights = ops.find(query, StreetLights.class);
		
		return new ResponseEntity<List<StreetLights>>(streetlights,HttpStatus.OK);	
	}

}

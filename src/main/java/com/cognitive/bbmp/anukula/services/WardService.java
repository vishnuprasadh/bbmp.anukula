package com.cognitive.bbmp.anukula.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.RoadColl;

@RequestMapping(value="/wards")
@RestController
public class WardService {

	MongoConfiguration config = null;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>  getRoadByWardCode(@PathVariable(name="id")String wardCode)
	{
		config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		Query query = new Query();
		query.addCriteria(Criteria.where("wardCode").is(wardCode));
		
		List<RoadColl> road = ops.find(query, RoadColl.class);
		
		return new ResponseEntity<List<RoadColl>>(road, HttpStatus.OK);
	}
	
}

package com.cognitive.bbmp.anukula.services;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation.LookupOperationBuilder;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.RoadColl;
import com.cognitive.bbmp.anukula.domain.RoadCollection;
import com.cognitive.bbmp.anukula.domain.Zone;
import com.cognitive.bbmp.anukula.repository.CustomRoadDAL;
import com.cognitive.bbmp.anukula.repository.RoadStateRespository;

@RestController
@RequestMapping(value="/zones")
public class ZoneService
{
	@Autowired
	MongoConfiguration config  ;
	
	@Autowired
	CustomRoadDAL customRoadbyZone;
	
	@RequestMapping(value="/city/{Id}")
	public ResponseEntity<?> getZonesByCityCode(@PathVariable(name="Id") String cityCode)
	{
		
		MongoOperations ops = config.mongoTemplate();
		Query query = new Query();
		query = AddQueryCondition(query, "cityCode", cityCode);
		
		List<Zone> zones = ops.find(query, Zone.class);
		
		return new ResponseEntity<List<Zone>>(zones, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{Id}")
	public ResponseEntity<?> getZonesByZoneCode(@PathVariable(name="Id") String zoneCode)
	{
		MongoOperations ops = config.mongoTemplate();
		
		Query query = new Query();
		query = AddQueryCondition(query, "zoneCode", zoneCode);
		
		List<Zone> zones = ops.find(query, Zone.class);
		
		return new ResponseEntity<List<Zone>>(zones, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/roadState/{Id}")
	public ResponseEntity<?> getRoadStateByZoneCode(@PathVariable(name="Id") String zoneCode)
	{
		return new ResponseEntity<List<RoadCollection>>( 
				customRoadbyZone.getRoadsByZoneCode(zoneCode),HttpStatus.OK);
		
	}
	
	
	
	private Query AddQueryCondition(Query query, String whereColumnName, String columnValue)
	{
		query.addCriteria(Criteria.where(whereColumnName).is(columnValue));
		return query;
	}
	

}

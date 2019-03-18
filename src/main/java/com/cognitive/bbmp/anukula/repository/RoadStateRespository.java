package com.cognitive.bbmp.anukula.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.cognitive.bbmp.anukula.domain.RoadState;


public interface RoadStateRespository extends MongoRepository<RoadState, String> {

	
	//@Query(value="db.zones.aggregate([ {'$match':{'zoneCode':?0}},{'$lookup':{'from':'roads','localField':'wardCode','foreignField':'wards.wardCode','as':'roads'}},   {'$project':{'roads':1}}  ]);")
	//List<Road> findRoadByZoneCode(String zoneCode);
	
}

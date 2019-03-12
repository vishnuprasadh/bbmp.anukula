package com.cognitive.bbmp.anukula.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.RoadColl;
import com.cognitive.bbmp.anukula.domain.RoadCollection;
import com.mongodb.annotations.Beta;


@ComponentScan
public interface CustomRoadDAL  {

	
	public List<RoadCollection> getRoadsByZoneCode(String wardCode);
	
		

}

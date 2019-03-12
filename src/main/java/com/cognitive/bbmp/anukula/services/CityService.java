package com.cognitive.bbmp.anukula.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.City;
import com.cognitive.bbmp.anukula.domain.Country;
import com.cognitive.bbmp.anukula.domain.State;

@RestController
@RequestMapping("/city")
public class CityService {
	
	
	MongoConfiguration config = null;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String addCity()
	{
		return "";
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ResponseEntity<?>  getAllCities()
	{
		config =new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		List<Country> country = ops.findAll(Country.class);
		
		return new ResponseEntity<List<Country>>(country,HttpStatus.OK ) ;
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?>  getCities(@PathVariable(name="id") String cityCode)
	{
		config =new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		Query query = new Query();
		query.addCriteria(Criteria.where("states.cities.cityCode").is(cityCode));
		List<Country> country = ops.find(query, Country.class);
		
		return new ResponseEntity<List<Country>>(country,HttpStatus.OK ) ;
	}
	
	
	@RequestMapping(value="/{citycode}/ward/{wardcode}",method=RequestMethod.GET)
	public ResponseEntity<?>  getWardByCityCode(@PathVariable(name="citycode") String cityCode,
			@PathVariable(name="wardCode") String wardCode)
	{
		config =new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		Query query = new Query();
		query.addCriteria(Criteria.where("states.cities.cityCode").is(cityCode));
		List<Country> country = ops.find(query, Country.class);
		
		return new ResponseEntity<List<Country>>(country,HttpStatus.OK ) ;
	}
	
	
	
}

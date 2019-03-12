package com.cognitive.bbmp.anukula.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cognitive.bbmp.anukula.domain.Country;

@EnableMongoRepositories
public interface CountryRepository extends MongoRepository<Country, String>
{
	
	List<Country> findByCountryCode(String countryCode);
	
	//Page<Country> findByCountryCode(String countryCode, Pageable pageable);
	
	
	
}

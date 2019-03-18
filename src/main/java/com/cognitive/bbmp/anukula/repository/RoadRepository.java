package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.Roads;

public interface RoadRepository extends MongoRepository<Roads, String> {

}

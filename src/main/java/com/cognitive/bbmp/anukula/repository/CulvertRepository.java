package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.Culverts;

@EnableMongoRepositories
public interface CulvertRepository extends MongoRepository<Culverts, String> {

}

package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.FootPaths;

public interface FootPathRepository extends MongoRepository<FootPaths, String> {

}

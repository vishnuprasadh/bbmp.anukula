package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.WardIssue;

@EnableMongoRepositories
public interface WardIssueRepository extends MongoRepository<WardIssue, String> {

}

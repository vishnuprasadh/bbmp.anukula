package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognitive.bbmp.anukula.domain.WardIssue;

public interface WardIssueRepository extends MongoRepository<WardIssue, String> {

}

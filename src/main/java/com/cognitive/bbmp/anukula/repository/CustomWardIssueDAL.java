package com.cognitive.bbmp.anukula.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.WardIssue;

@EnableMongoRepositories
public interface CustomWardIssueDAL {

	
	List<WardIssue> findWardIssueByCodeAndStatus(String wardCode, String status);
	
}

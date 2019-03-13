package com.cognitive.bbmp.anukula.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cognitive.bbmp.anukula.domain.IssueSnapshot;
import com.cognitive.bbmp.anukula.domain.WardIssue;

@EnableMongoRepositories
public interface CustomWardIssueDAL {

	
	public List<IssueSnapshot> getDashboardByWardForGivenWardWhereStatusNotEqual(String wardCode, String whereStatusNotIn);
	
}

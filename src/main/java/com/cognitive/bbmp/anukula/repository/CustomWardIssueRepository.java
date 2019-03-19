package com.cognitive.bbmp.anukula.repository;

import java.util.List;

import org.bson.Document;
import org.hibernate.criterion.AggregateProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.FacetOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.aggregation.FacetOperation.FacetOperationBuilder;
import org.springframework.data.mongodb.core.aggregation.Field;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;


import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.IssueSnapshot;
import com.cognitive.bbmp.anukula.domain.WardIssue;
import com.cognitive.bbmp.anukula.services.WardIssueService;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Facet;
import com.mongodb.operation.AggregateOperation;

import javassist.expr.NewArray;


@Component
public class CustomWardIssueRepository implements CustomWardIssueDAL {

	private static final Logger logger = LoggerFactory.getLogger(CustomWardIssueRepository.class);
	
	
	final String dashboardSQL = "db.wardIssue.aggregate(\n" + 
								" $match:{status:{$ne:\"Closed\"}}\n" + 
								" },\n" + 
								"  {\n" + 
								" $facet:{\n" + 
								" \"bylocation\":[\n" + 
								" 	{$unwind:\"$location\"},{$sortByCount:\"$location\"}],\n" + 
								" \"bypriority\":[\n" + 
								"	{$group:{\"_id\":{\"location\":\"$location\",\"priority\":\"$priority\"},\"count\":{\"$sum\":1}}}\n" + 
								"	{$sort\n" + 
								"	],\n" + 
								" \"bystatus\":[\n" + 
								"    {$group:{\"_id\":{\"location\":\"$location\",\"status\":\"$status\"},\"count\":{\"$sum\":1}}}]\n" + 
								"}}\n" + 
								"]);";	
	
	
	@Autowired
	MongoConfiguration config ;
	
	@Override
	public List<IssueSnapshot> getDashboardByWardForGivenWardWhereStatusNotEqual(String wardCode, String whereStatusNotIn) {
		if (config==null) config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		
		/*BasicQuery query = new BasicQuery(dashboardSQL);
		//MongoDatabase db = config.mongoClient().getDatabase("bbmp.anukula");
		
		String output = ops.findOne(query, String.class, "issueSnapshot");*/
		
		//MatchOperation matchOps = new MatchOperation(Criteria.where("status").ne("Closed"));
		//UnwindOperation unwind1 = new UnwindOperation() 
		
		
		/*FacetOperation facets =  facet(
					match(Criteria.where("status").ne(whereStatusNotIn).and("wardCode").is(wardCode)),
					unwind("location"),
					sortByCount("location"))
					.as("bylocation")
					.and(
							match(Criteria.where("status").ne(whereStatusNotIn).and("wardCode").is(wardCode)),
							group("location","priority").count().as("count")
						).as("bypriority")
					.and(
							Criteria.where("status").ne(whereStatusNotIn).and("wardCode").is(wardCode)),
							group("location","status").count().as("count")
						).as("bystatus");
		*/
		
		logger.info("Aggregate for dashboard starting now for ward:{}",wardCode);
		
		AggregationResults<IssueSnapshot> snapshot = ops.aggregate (
					newAggregation(
					match(Criteria.where("status").ne(whereStatusNotIn).and("wardCode").is(wardCode)),
							
					facet(
					unwind("location"),
					sortByCount("location"))
					.as("bylocation")
					.and(
							group("location","priority").count().as("count")
						).as("bypriority")
					.and(
							group("location","status").count().as("count")
						).as("bystatus")
					),  
					"wardIssue",IssueSnapshot.class);
		
		logger.info("Aggregate for dashboard successfully completed for ward:{}",wardCode);
		return snapshot.getMappedResults();
		
	}

	

}

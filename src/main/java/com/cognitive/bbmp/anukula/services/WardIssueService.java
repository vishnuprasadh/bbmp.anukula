package com.cognitive.bbmp.anukula.services;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.IssueHistory;
import com.cognitive.bbmp.anukula.domain.IssueSnapshot;
import com.cognitive.bbmp.anukula.domain.WardIssue;
import com.cognitive.bbmp.anukula.repository.CustomWardIssueRepository;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping(value="/issues")
public class WardIssueService {

	private static final Logger logger = LoggerFactory.getLogger(WardIssueService.class);
	
	@Autowired
	CustomWardIssueRepository customWardRepo;
	
	@Autowired
	MongoConfiguration config;
	
	@RequestMapping(value="/ward/{wardCode}", method=RequestMethod.GET)
	public ResponseEntity<?> getIssuesByWard(@PathVariable(value="wardCode") String wardCode)
	{
		if (config ==null) config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("wardCode").is(wardCode));
		
		MongoOperations ops = config.mongoTemplate();
		
		logger.info(":Get: operation for :wardIssue: for ward:{} starting.",wardCode);
		
		List<WardIssue> issues = ops.find(query, WardIssue.class);
		
		logger.info(":Get: operation for :wardIssue: for ward:{} starting.",wardCode);
		
		
		return new ResponseEntity<List<WardIssue>>(issues,HttpStatus.OK);
	}
	
	@RequestMapping(value="/ward/{wardCode}/status/{status}", method=RequestMethod.GET)
	public ResponseEntity<?> getIssuesByWardandStatus(@PathVariable(value="wardCode") String wardCode, 
			@PathVariable(value="status") String status)
	{
		if (config ==null) config = new MongoConfiguration();
		Query query = new Query();
		query.addCriteria(Criteria.where("wardCode").is(wardCode).and("status").is(status));
		
		MongoOperations ops = config.mongoTemplate();
		
		logger.info(":Get: operation for :wardIssue: for ward:{} with status {} starting.",wardCode,status);
		
		List<WardIssue> issues = ops.find(query, WardIssue.class);
		logger.info(":Get: operation for :wardIssue: for ward:{} with status {} completed.",wardCode,status);
		
		return new ResponseEntity<List<WardIssue>>(issues, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/history/{issueId}", method=RequestMethod.GET)
	public ResponseEntity<?> getIssueHistoryByIssueId(@PathVariable(value="issueId") String issueId)
	{
		if (config ==null) config = new MongoConfiguration();
		
		/*LookupOperation operation = LookupOperation.newLookup()
				.from("wardIssue")
				.localField("issueId")
				.foreignField("_id")
				.as("wardIssue");
		ops.aggregate(agg, "wardIssue", WardIssue.class);
		
		Aggregation agg = Aggregation.newAggregation(operation);
		*/
		Query query = new Query();
		query.addCriteria(Criteria.where("issueId").is(issueId));
		//LookupOperation operation2 = Aggregation.lookup ("wardIssues", "issueId", "_id", "wardIssue");
		
		MongoOperations ops = config.mongoTemplate();
		
		logger.info(":Get: operation for :IssueHistory: for IssueId:{} starterd.",issueId);
		List<IssueHistory> history = ops.find(query, IssueHistory.class);
		logger.info(":Get: operation for :IssueHistory: for IssueId:{} completed.",issueId);
		
		return new ResponseEntity<List<IssueHistory>>(history, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/bulkupdate", method=RequestMethod.POST)
	public ResponseEntity<?> bulkUpdateIssues(@RequestBody List<WardIssue> issues)
	{
		if (config ==null) config = new MongoConfiguration();
		//DB dbBBMPAnukula = config.mongoClient().getDB("bbmpanukula");
		
		MongoOperations ops = config.mongoTemplate();
		
		BulkOperations bulkOps = ops.bulkOps(BulkMode.ORDERED, "wardIssue");
		
		List<Pair<Query,Update>> upserts = new ArrayList<Pair<Query,Update>>();
		
		for (WardIssue issue : issues)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("issueId").is(issue.getIssueId()));
			Update upd = new Update();
			upd.set("location", issue.getLocation());
			upd.set("complaintDate", issue.getComplaintDate());
			upd.set("complaintSource", issue.getComplaintSource());
			upd.set("wardCode", issue.getWardCode());
			upd.set("typeofComplaint", issue.getTypeofComplaint());
			upd.set("category", issue.getCategory());
			upd.set("priority", issue.getPriority());
			upd.set("status", issue.getStatus());
			upd.set("dateUpdated", new Timestamp(new java.util.Date().getDate()).toString()  );

			Pair<Query,Update> pair = Pair.of(query,upd);
			
			upserts.add(pair);
		}
		BulkWriteResult bulkResult = bulkOps.upsert(upserts).execute();
		
		int matchCount = bulkResult.getDeletedCount() + bulkResult.getInsertedCount()
		+ bulkResult.getUpserts().size() + bulkResult.getModifiedCount();
		
		//int matchCount = bulkOps.insert(issues).execute().getMatchedCount();
		
		//MongoCollection<TDocument> bulklWrites = temp.getCollection("wardIssue");
		
		return new ResponseEntity<>(matchCount, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/update/history", method=RequestMethod.POST)
	public ResponseEntity<?> updateIssueHistory(@RequestBody IssueHistory history)
	{
		long matchedCount;
		Query historyQuery = new Query();
		Query issueQuery = new Query();
		
		
		if (history.getStatus()==null)
			history.setStatus("New");
		
		
		issueQuery.addCriteria(Criteria.where("_id").is(history.getIssueId()));
		Update issueUpd = new Update();
		issueUpd.set("status", history.getStatus());
		
		//In case we also update an existing history
		if (history.get_id()!=null)
		{
			historyQuery.addCriteria(Criteria.where("_id").is(history.get_id()));
			
			Update historyUpd = new Update();
			historyUpd.set("actionTaken", history.getActionTaken());
			historyUpd.set("dateUpdated", new Timestamp(new java.util.Date().getTime()).toString());
			historyUpd.set("issueId", history.getIssueId());
			historyUpd.set("siteReport", history.getSiteReport());
			historyUpd.set("statusComments", history.getStatusComments());
			
			
			matchedCount= updateIssueHistory(historyQuery,issueQuery, historyUpd, issueUpd, history);
	
		}
		//If we update by entering a new history or sitevisit along with status update
		else
		{
			//MongoOperations ops = config.mongoTemplate();
			history.setDateUpdated( new Timestamp(new java.util.Date().getTime()).toString());
			matchedCount= addNewIssueHistory(historyQuery, issueQuery, null, issueUpd, history);
		}
	
		return new ResponseEntity<>(matchedCount, HttpStatus.OK);
		
	}
	
	@Transactional
	private long addNewIssueHistory(Query historyQuery, Query issueQuery, Update historyUpd, 
			Update issueUpd, IssueHistory history)
	{
		if (config ==null) config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		UpdateResult issueResult = ops.updateFirst(issueQuery, issueUpd, "wardIssue");
		IssueHistory result = ops.insert(history, "issueHistory");
		return issueResult.getMatchedCount();
	}
	
	@Transactional
	private long updateIssueHistory(Query historyQuery, Query issueQuery, Update historyUpd, 
			Update issueUpd, IssueHistory history)
	{
		if (config ==null) config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		UpdateResult historyResult = ops.upsert(historyQuery, historyUpd, "issueHistory");
		UpdateResult issueResult = ops.upsert(issueQuery, issueUpd, "wardIssue");
		
		return issueResult.getMatchedCount();
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<?> addNewIssue(@RequestBody WardIssue wardIssue )
	{
		if (config ==null) config = new MongoConfiguration();
		
		Query query = new Query();
		
		MongoOperations ops = config.mongoTemplate();
		
		//If no status is set, set default as new
		if (wardIssue.getStatus()==null)
				wardIssue.setStatus("New");
				
		if(wardIssue.get_id()!=null)
		{
			Update upd = new Update();
			query.addCriteria(Criteria.where("_id").is(wardIssue.get_id()));
			
			upd.set("issueId", wardIssue.getIssueId());
			upd.set("complaintDate", wardIssue.getComplaintDate());
			upd.set("complaintSource", wardIssue.getComplaintSource());
			upd.set("location", wardIssue.getLocation());
			upd.set("typeOfComplaint", wardIssue.getTypeofComplaint());
			upd.set("category", wardIssue.getCategory());
			upd.set("wardCode", wardIssue.getWardCode());
			upd.set("status", wardIssue.getStatus());
			upd.set("priority",wardIssue.getPriority());
			upd.set("dateUpdated", new Timestamp( new java.util.Date().getTime() ).toString() );
			//upd.push("history",wardIssue.getHistory());
			UpdateResult result = ops.upsert(query, upd, "wardIssue");
			
			return new ResponseEntity<Long> (result.getMatchedCount(),HttpStatus.OK);
		}
		else
		{
			wardIssue.setDateUpdated( new Timestamp(new java.util.Date().getTime()).toString());
			
			WardIssue result = ops.insert(wardIssue,"wardIssue");
			return new ResponseEntity<String>(result.get_id(),HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value="/snapshot/{wardCode}")
	public ResponseEntity<?> getIssueSnapshot(@PathVariable(name="wardCode") String wardCode)
	{
		List<IssueSnapshot> response = customWardRepo.getDashboardByWardForGivenWardWhereStatusNotEqual(wardCode, "Closed");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
}

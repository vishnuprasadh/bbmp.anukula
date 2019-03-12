package com.cognitive.bbmp.anukula.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.RoadColl;
import com.cognitive.bbmp.anukula.domain.RoadCollection;
import com.cognitive.bbmp.anukula.domain.Zone;
import com.cognitive.bbmp.anukula.services.ZoneService;
import com.mongodb.BasicDBObject;
import com.mongodb.operation.AggregateOperation;

@ComponentScan
public class CustomRoadRepository implements CustomRoadDAL {

	MongoConfiguration config = new MongoConfiguration();

	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoadCollection> getRoadsByZoneCode(String zoneCode)
	{
		// TODO Auto-generated method stub
		
			
			List<Zone> zones = getZonesbycode(zoneCode);
			
			MongoOperations ops = config.mongoTemplate();
			MatchOperation match = Aggregation.match(Criteria.where("zoneCode").is(zoneCode));
			LookupOperation lookup = Aggregation.lookup("roads", "wardCode", "wards.wardCode", "roads");
			//UnwindOperation unwind = Aggregation.unwind("roads",true);
			ProjectionOperation project = Aggregation.project("roads");
			Aggregation agg = Aggregation.newAggregation(match,lookup, project);
			
			AggregationResults<?> result = ops.aggregate(agg, Zone.class,RoadCollection.class );
			
			
			return (List<RoadCollection>) result.getMappedResults();
	}
	
	
	private List<Zone> getZonesbycode(String zoneCode)
	{
		MongoOperations ops = config.mongoTemplate();
		MatchOperation match = Aggregation.match(Criteria.where("zoneCode").is(zoneCode));
		Aggregation agg = Aggregation.newAggregation(match);
		
		AggregationResults<Zone> result = ops.aggregate(agg,Zone.class, Zone.class);
		
		return result.getMappedResults();
		
	}
	

}

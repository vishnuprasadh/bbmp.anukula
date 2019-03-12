package com.cognitive.bbmp.anukula;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.City;
import com.cognitive.bbmp.anukula.domain.Country;
import com.cognitive.bbmp.anukula.domain.State;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoClient;

import org.springframework.data.mongodb.core.query.Criteria;


@SpringBootApplication(scanBasePackages= {"com.cognitive.bbmp.anukula"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class Application {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		
	}

}


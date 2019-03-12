package com.cognitive.bbmp.anukula.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfiguration extends AbstractMongoConfiguration
{
	
	@Bean
	public MongoTransactionManager transactionManager(MongoDbFactory factory)
	{
		return new MongoTransactionManager(factory);
	}
	
	@Autowired
	private Environment env;
	
	@Override
	public String getDatabaseName()
	{
		
		return "bbmpanukula";
	}
	
	@Override
	@Bean
	public MongoClient mongoClient()
	{
		MongoClient client = new MongoClient("127.0.0.1");
		return client;
	
	}
	
	@Bean
	public MongoTemplate mongoTemplate()
	{
		return new MongoTemplate(mongoClient(),getDatabaseName());
	}

}

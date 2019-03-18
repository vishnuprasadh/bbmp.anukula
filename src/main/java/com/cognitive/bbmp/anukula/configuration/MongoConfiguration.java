package com.cognitive.bbmp.anukula.configuration;

import java.util.List;

import javax.annotation.Resource;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.cognitive.bbmp.anukula.domain.Roads;
import com.mongodb.MongoClient;

@Component
@Configuration
@EnableMongoRepositories(basePackages="com.cognitive.bbmp.anukula")
public class MongoConfiguration extends AbstractMongoConfiguration
{
	@Value("${apphosting}")  String appHosting;
	
	@Bean
	public MongoTransactionManager transactionManager(MongoDbFactory factory)
	{
		return new MongoTransactionManager(factory);
	}
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Environment env;
	
	@Override
	public String getDatabaseName()
	{
		
		return "bbmpanukula";
	}
	
	
	@Bean
	@Override
	public MongoClient mongoClient()
	{
		String activeProfile = env.getActiveProfiles()[0];
		
		if(activeProfile.toLowerCase().equals("production"))
		{
			if (appHosting==null)
				appHosting = "mongodb+srv://bbmpanukula:bbmpanukula@cluster0-edgpx.mongodb.net/bbmpanukula?retryWrites=true";
			MongoClientURI uri = new MongoClientURI(appHosting);
			//MongoClient client = new MongoClient("127.0.0.1");
			MongoClient client = new MongoClient(uri);
			MongoDatabase db = client.getDatabase("bbmpanukula");
			//MongoCollection<Document> roads = db.getCollection("roads");
				
			return client;
		}
		else
		{
			MongoClient client = new MongoClient(appHosting);
			MongoDatabase db = client.getDatabase("bbmpanukula");
			return client;
		}
	
	}
	
	@Override
	public String getMappingBasePackage()
	{
		return "com.cognitive.bbmp.anukula";
	}
	
	@Bean
	public MongoTemplate mongoTemplate()
	{
		return new MongoTemplate(mongoClient(),getDatabaseName());
	}

}

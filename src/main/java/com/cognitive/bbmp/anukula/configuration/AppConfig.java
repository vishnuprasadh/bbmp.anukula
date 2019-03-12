package com.cognitive.bbmp.anukula.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cognitive.bbmp.anukula.domain.RoadColl;
import com.cognitive.bbmp.anukula.repository.CustomRoadRepository;

@Configuration
public class AppConfig {
	
	@Bean
	public CustomRoadRepository customRoadRepository()
	{
		return new CustomRoadRepository();
	}
	
	
}

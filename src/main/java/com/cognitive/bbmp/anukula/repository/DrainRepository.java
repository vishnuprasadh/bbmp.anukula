package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.cognitive.bbmp.anukula.domain.Drains;

public interface DrainRepository extends MongoRepository<Drains, String> {

}

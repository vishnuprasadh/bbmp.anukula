package com.cognitive.bbmp.anukula.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognitive.bbmp.anukula.domain.Culverts;

public interface CulvertRepository extends MongoRepository<Culverts, String> {

}

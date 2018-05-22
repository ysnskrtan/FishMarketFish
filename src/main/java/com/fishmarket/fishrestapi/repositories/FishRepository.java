package com.fishmarket.fishrestapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fishmarket.fishrestapi.models.Fish;

@Repository
public interface FishRepository extends MongoRepository<Fish, String> {

}

package com.example.kafkabatch.repository;

import com.example.kafkabatch.model.entity.CIServerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CIServerRepository extends MongoRepository<CIServerEntity, String> {
}

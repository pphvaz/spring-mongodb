package com.pedro.mongoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pedro.mongoapp.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}

package com.crafts.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crafts.profileservice.model.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}

package com.crafts.profileservice.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.crafts.profileservice.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public UserProfile save(UserProfile userProfile) {
        dynamoDBMapper.save(userProfile);
        return userProfile;
    }

    public UserProfile getUserProfileById(String userId) {
        return dynamoDBMapper.load(UserProfile.class, userId);
    }

    public String delete(String userId) {
        UserProfile userProfile = dynamoDBMapper.load(UserProfile.class, userId);
        dynamoDBMapper.delete(userProfile);
        return "User " + userId + " deleted!";
    }

    public String update(String userId, UserProfile userProfile) {
        /* Save user profile based on certain conditions
           Here, We are checking if the user_id is matching with the userId of the UserProfile object
         */
        dynamoDBMapper.save(userProfile,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("userId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(userId)
                                )));
        return userId;
    }

}

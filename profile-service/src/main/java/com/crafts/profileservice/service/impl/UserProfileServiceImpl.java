package com.crafts.profileservice.service.impl;

import com.crafts.profileservice.entity.UserProfile;
import com.crafts.profileservice.model.UserProfileEventDTO;
import com.crafts.profileservice.producer.UserProfileKafkaProducer;
import com.crafts.profileservice.repository.UserProfileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements com.crafts.profileservice.service.UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserProfileKafkaProducer userProfileKafkaProducer;

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        UserProfile savedUser= new UserProfile();
        //userProfileRepository.save(userProfile);
        // Extract the required fields
        UserProfileEventDTO userProfileDTO = new UserProfileEventDTO();
        userProfileDTO.setUserId(userProfile.getUserId());
        userProfileDTO.setSubscriptions(userProfile.getSubscriptions());
        String jsonMessage = convertToJson(userProfileDTO);
        userProfileKafkaProducer.send(jsonMessage, "USER_PROFILE_CREATED");
        return savedUser;
    }

    @Override
    public UserProfile getUserProfileById(String userId) {
        return userProfileRepository.getUserProfileById(userId);
    }

    @Override
    public String delete(String userId) {
        return userProfileRepository.delete(userId);
    }

    @Override
    public String update(String userId, UserProfile userProfile) {
        return userProfileRepository.update(userId, userProfile);
    }

//    public String getStatus(String id, String key) {
//        UserProfiles userProfilesEO = userProfileRepository.findStatusByIdAndValidationKey(id, key);
//        UserProfile userProfileDTO = userProfileMapper.entityToDto(userProfilesEO);
//        return userProfileDTO.get;
//    }

    private String convertToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // Handle the exception
            return null;
        }
    }
}

package com.crafts.profileservice.service.impl;

import com.crafts.profileservice.model.UserProfileEventDTO;
import com.crafts.profileservice.producer.UserProfileKakfaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crafts.profileservice.model.UserProfile;
import com.crafts.profileservice.repository.UserProfileRepository;
import com.crafts.profileservice.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserProfileKakfaProducer userProfileKakfaProducer;

    public UserProfile createProfile(UserProfile userProfile) {
        UserProfile savedUser = userProfileRepository.save(userProfile);

        // Extract the required fields
        UserProfileEventDTO userProfileDTO = new UserProfileEventDTO();
        userProfileDTO.setUserId(savedUser.getUserId());
        userProfileDTO.setSubscriptions(savedUser.getSubscriptions());

        // Serialize the UserProfileDTO to a JSON string
        String jsonMessage = convertToJson(userProfileDTO);
        userProfileKakfaProducer.send(jsonMessage, "USER_PROFILE_CREATED");
        return savedUser;
    }

    // Helper method to convert an object to a JSON string
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

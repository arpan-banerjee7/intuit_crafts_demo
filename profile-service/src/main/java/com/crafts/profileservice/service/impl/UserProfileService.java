package com.crafts.profileservice.service.impl;

import com.crafts.profileservice.entity.UserProfile;
import com.crafts.profileservice.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService implements com.crafts.profileservice.service.UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;


    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
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
}

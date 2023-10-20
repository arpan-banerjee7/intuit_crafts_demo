package com.crafts.profileservice.service;

import com.crafts.profileservice.entity.UserProfile;

public interface UserProfileService {

//	String getStatus(String userId, String productId);

    UserProfile saveUserProfile(UserProfile userProfile);

	UserProfile getUserProfileById(String userId);

    String delete(String userId);

    String update(String userId, UserProfile userProfile);
}

package com.crafts.profileservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crafts.profileservice.model.UserProfile;
import com.crafts.profileservice.service.UserProfileService;


@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/createProfile")
    public UserProfile createProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createProfile(userProfile);
    }
}

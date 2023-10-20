package com.crafts.profileservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crafts.profileservice.entity.UserProfile;
import com.crafts.profileservice.service.UserProfileService;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

//    @PostMapping("/getStatus")
//    public String getStatus(@RequestBody UserProductRequest userProductRequest) {
//        return userProfileService.getStatus(userProductRequest.getUserId(),
//                userProductRequest.getProductId());
//    }

    @GetMapping("/user/{userId}")
    public UserProfile getUserProfile(@PathVariable("userId") String userId){
        return userProfileService.getUserProfileById(userId);
    }
    @PostMapping("/user/create")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.saveUserProfile(userProfile);
    }

    @PutMapping("/user/update/{userId}")
    public String updateUserProfile(@PathVariable("userId") String userId,
                                    @RequestBody UserProfile userProfile) {
        return userProfileService.update(userId, userProfile);
    }

    @DeleteMapping("/user/delete/{userId}")
    public String deleteUserProfile(@PathVariable("userId") String userId) {
        return userProfileService.delete(userId);
    }

}

package com.crafts.profileservice.model;

import com.crafts.profileservice.enums.ValidationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private String userId;
    private BusinessProfile businessProfile;
    private ValidationStatusEnum consolidatedStatus;
    private List<String> subscriptions;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class BusinessProfile {

    private String companyName;
    private String legalName;
    private Address businessAddress;
    private Address legalAddress;
    private TaxIdentifiers taxIdentifiers;
    private String email;
    private String website;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Address {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String country;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class TaxIdentifiers {
    private String pan;
    private String ein;

}

package com.crafts.profileservice.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.crafts.profileservice.enums.ValidationStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user-profiles")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {

	@Id
	private String userId;
	private BusinessProfile businessProfile;
	private String consolidatedStatus;
	private Map<String, ProductValidation> productValidations;

}

class BusinessProfile {

	private String companyName;
	private String legalName;
	private Address businessAddress;
	private Address legalAddress;
	private TaxIdentifiers taxIdentifiers;
	private String email;
	private String website;

}

class Address {

	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zip;
	private String country;

}

class TaxIdentifiers {

	private String PAN;
	private String EIN;

}

class ProductValidation {

	private ValidationStatusEnum status;
	private Date timestamp;

}

package com.crafts.profileservice.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class BusinessProfile {

    @DynamoDBAttribute
    private String companyName;

    @DynamoDBAttribute
    private String legalName;

    @DynamoDBAttribute
    private Address businessAddress;

    @DynamoDBAttribute
    private Address legalAddress;

    @DynamoDBAttribute
    private TaxIdentifiers taxIdentifiers;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String website;

}

package com.crafts.profileservice.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class Address {

    @DynamoDBAttribute
    private String line1;

    @DynamoDBAttribute
    private String line2;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String state;

    @DynamoDBAttribute
    private String zip;

    @DynamoDBAttribute
    private String country;

}

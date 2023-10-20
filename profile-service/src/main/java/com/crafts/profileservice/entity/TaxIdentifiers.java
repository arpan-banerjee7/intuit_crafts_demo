package com.crafts.profileservice.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class TaxIdentifiers {

    @DynamoDBAttribute
    private String pan;

    @DynamoDBAttribute
    private String ein;

}

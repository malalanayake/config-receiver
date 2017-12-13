package com.sysensor.config.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Value("${aws.region}")
    private String region;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
       // BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                //.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
        return amazonDynamoDB;
    }
}

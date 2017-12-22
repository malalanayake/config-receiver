package com.sysensor.config.service.impl;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.sysensor.config.service.IConfigService;
import com.sysensor.config.table.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRouteService implements IConfigService<ApplicationConfig, String> {


    @Autowired
    AmazonDynamoDB amazonDynamoDB;

    @Override
    public AmazonDynamoDB getAmazonDynamoDB() {
        return amazonDynamoDB;
    }

    @Override
    public ApplicationConfig remove(ApplicationConfig applicationConfig) {
        return null;
    }

    @Override
    public ApplicationConfig modify(ApplicationConfig applicationConfig) {
        return null;
    }

    @Override
    public ApplicationConfig get(String s) {
        return null;
    }
}

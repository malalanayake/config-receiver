package com.sysensor.config.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public interface IConfigService<T, R> {

    default T add(T t) {
        DynamoDBMapper mapper = new DynamoDBMapper(getAmazonDynamoDB());
        T configRoute = t;
        mapper.save(configRoute);
        return configRoute;
    }


    AmazonDynamoDB getAmazonDynamoDB();

    T remove(T t);

    T modify(T t);

    T get(R r);
}

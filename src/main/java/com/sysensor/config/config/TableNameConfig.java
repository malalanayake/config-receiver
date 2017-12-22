package com.sysensor.config.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableNameConfig {
    Logger LOG = Logger.getLogger(this.getClass());
    public static final String ApplicationConfig = "ApplicationConfig";


    @Autowired
    AmazonDynamoDB amazonDynamoDB;

    public void createApplicationConfigTable(){
        try {
            CreateTableRequest request = new CreateTableRequest()
                    .withAttributeDefinitions(
                            new AttributeDefinition().withAttributeName(com.sysensor.config.table.ApplicationConfig.ID).withAttributeType("S"),
                            new AttributeDefinition().withAttributeName(com.sysensor.config.table.ApplicationConfig.NAME).withAttributeType("S"))
                    .withTableName(ApplicationConfig)
                    .withKeySchema(new KeySchemaElement().withAttributeName(com.sysensor.config.table.ApplicationConfig.ID).withKeyType(KeyType.HASH),
                            new KeySchemaElement().withAttributeName(com.sysensor.config.table.ApplicationConfig.NAME).withKeyType(KeyType.RANGE))
                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(5L));
            CreateTableResult response = amazonDynamoDB.createTable(request);
        }catch (Exception ex){
            LOG.error("SKIP the table creation:"+ ex.getMessage());
        }
    }
}

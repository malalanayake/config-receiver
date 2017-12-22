package com.sysensor.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.sysensor.config.config.TableNameConfig;
import com.sysensor.config.table.ApplicationConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConfigReceiverAppStart implements ApplicationRunner {
	Logger LOG = Logger.getLogger(this.getClass());

	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	@Autowired
	TableNameConfig tableNameConfig;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConfigReceiverAppStart.class, args);
		//System.exit(SpringApplication.exit(context));
		System.out.print(context.toString());
	}

	private void createApplicationConfig() {
		DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
		ApplicationConfig applicationConfig = new ApplicationConfig("Srilanka_Transportation","West");
		mapper.save(applicationConfig);
	}

	private ApplicationConfig getBook() {
		DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
		return mapper.load(ApplicationConfig.class, "1");
	}


	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		tableNameConfig.createApplicationConfigTable();
		createApplicationConfig();
	}
}

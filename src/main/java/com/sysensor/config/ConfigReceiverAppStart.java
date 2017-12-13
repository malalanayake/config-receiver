package com.sysensor.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.sysensor.config.config.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConfigReceiverAppStart implements CommandLineRunner{


	@Autowired
	AmazonDynamoDB amazonDynamoDB;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConfigReceiverAppStart.class, args);
		System.exit(SpringApplication.exit(context));
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("---------------- START UPLOAD FILE ----------------");
//		s3Services.uploadFile(key, uploadFilePath);
//		System.out.println("---------------- START DOWNLOAD FILE ----------------");
//		s3Services.downloadFile(key, downloadFilePath);
//		System.out.println("DONE!");
		System.out.println("Found document: ");
		//CRUD.testCRUDOperations(amazonDynamoDB);
		createBook();
		Book book = getBook();
		System.out.println("Found document: " + book);


	}

	private void createBook() {
		DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
		Book book = new Book("2", "Minecraft Modding with Forge", "1234", "29.99");
		mapper.save(book);
	}

	private Book getBook() {
		DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
		return mapper.load(Book.class, "1");
	}


}

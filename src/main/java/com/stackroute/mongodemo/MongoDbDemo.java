package com.stackroute.mongodemo;

import com.mongodb.MongoException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;


public class MongoDbDemo {

	public static void main(String[] args) {
		try {
			MongoOperation mongoOperation = new MongoOperation();
			mongoOperation.createDocument();
//			mongoOperation.updateDocument();
//			mongoOperation.deleteDocument();


		} catch (MongoException | UnknownHostException e) {
			e.printStackTrace();
		}
	}


}

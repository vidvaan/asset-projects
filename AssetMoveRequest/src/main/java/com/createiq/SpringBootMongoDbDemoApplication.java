package com.createiq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class SpringBootMongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbDemoApplication.class, args);
	}

}

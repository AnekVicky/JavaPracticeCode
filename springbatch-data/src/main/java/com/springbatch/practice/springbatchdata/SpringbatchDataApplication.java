package com.springbatch.practice.springbatchdata;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbatchDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchDataApplication.class, args);
	}

}

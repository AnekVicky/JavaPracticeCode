package com.java.designPatterns.designPatterns.chainOfResponsibilities.ex1;

/**
 * Created by anekkumarsingh on 2024-06-11 at 11:48:09
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		logProcessor.log(Level.DEBUG,"Debugging for LogProcessor");

	}

}

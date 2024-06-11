package com.java.designPatterns.designPatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		logProcessor.log(Level.DEBUG,"Debugging for LogProcessor");

	}

}

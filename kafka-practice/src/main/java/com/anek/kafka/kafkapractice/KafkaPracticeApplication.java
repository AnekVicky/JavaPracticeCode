package com.anek.kafka.kafkapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableRetry
@EnableAsync
public class KafkaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPracticeApplication.class, args);
	}

}

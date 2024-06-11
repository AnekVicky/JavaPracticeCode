package com.anek.kafka.kafkapractice.controller;

import com.anek.kafka.kafkapractice.service.ElasticBulkProcessor;
import com.anek.kafka.kafkapractice.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/event-api")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @Autowired
    ElasticBulkProcessor elasticBulkProcessor;

    @GetMapping("/publish/{message}")
    private ResponseEntity<?> publishMessage(@PathVariable String message){

        try {
            publisher.sendMessageToTopic(message);
            return ResponseEntity.ok("Message Sent Successful");

        }catch (Exception ex){
            System.out.println("Exception occurred in event controller");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
    @GetMapping("/publish/retry/{message}")
    private ResponseEntity<?> publishRetryMessage(@PathVariable String message){

        try {
            System.out.println("Thread : "+Thread.currentThread().getName());
            CompletableFuture completableFuture = publisher.sendRetryMessageToTopic(message);
            completableFuture.whenComplete(
                    (result, exception) -> {
                        System.out.println("result : "+result);

                        if (exception == null) {
                            System.out.println("Send Message topic : Successfully !");
                        } else {
                            System.err.println("storing in elastic cache");
                        }
                    });
            //elasticBulkProcessor.bulkProcessorListener();
            return ResponseEntity.ok("Message Sent Successful");

        }catch (Exception ex){
            System.out.println("Exception occurred in event controller");
            System.out.println("storing in elastic cache");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
}

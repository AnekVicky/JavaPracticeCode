package com.anek.kafka.kafkapractice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    private Logger logger = LoggerFactory.getLogger(KafkaMessagePublisher.class);
    @Autowired
    private KafkaTemplate<String,Object> template;



    public String sendMessageToTopic(String message) {

        CompletableFuture<SendResult<String, Object>> future = null;
                //template.send("ocr-topic", message);

        for(int i =0 ; i < 10000; i++){
            future = template.send("ocr-topic", message+" "+i);
        }

        future.whenComplete(
                (result, exception) -> {
                    String topic = result.getRecordMetadata().topic();
                    int partition = result.getRecordMetadata().partition();
                    long offset = result.getRecordMetadata().offset();

                    if (exception == null) {
                        System.out.println("Send Message topic : " + topic + " partition : " + partition +
                                " offset : "+offset+" Successfully !");
                    } else {
                        System.err.println("Unable to send message");
                    }
                }
        );

     return "";
    }
    @Retryable(
            maxAttempts = 3,
            /*retryFor = IOException.class,*/
            backoff = @Backoff(delay = 2000))
    @Async
    public CompletableFuture sendRetryMessageToTopic(String message) {
        logger.info("******  start sending *******");
        System.out.println("Thread : " + Thread.currentThread().getName());
        try {
            Class.forName("".getClass().getName());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return send(message);
    }

    private CompletableFuture send(String message) {
        logger.info("In sendRetryMessageToTopic ...");
        //template.send("isearch-topic-dlt", message+"_dlt");
        throw new RuntimeException("sendRetryMessageToTopic exception...");
    }
    @Recover
    public CompletableFuture sendRecoverMessageToDLT(String message)  {
        System.out.println("Thread : "+Thread.currentThread().getName());
        logger.info("In sendRecoverMessageToDLT ...");
        throw new RuntimeException("sendRecoverMessageToDLT exception...");
        //template.send("ocr-topic-dlt", message+"_dlt");
    }
}

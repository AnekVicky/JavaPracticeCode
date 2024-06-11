package com.anek.kafka.kafkapractice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageListener {

    private Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @Retryable
    @KafkaListener(topics = "isearch-topic",groupId = "isearch-consumer")
    public void consume(String message){
    logger.info("Message Received : "+message);

    }

    @KafkaListener(topics = "isearch-topic-dlt",groupId = "isearch-consumer-dlt")
    public void consumeRetry(String message){
        logger.info("Message Recovered received : "+message);

    }


}

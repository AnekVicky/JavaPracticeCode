package com.anek.kafka.kafkapractice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        NewTopic newTopic = new NewTopic("ocr-topic",5,(short) 1);
        return newTopic;
    }

}

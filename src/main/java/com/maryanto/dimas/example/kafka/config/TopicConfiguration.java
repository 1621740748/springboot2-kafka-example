package com.maryanto.dimas.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfiguration {

    @Bean
    public NewTopic exampleTopic() {
        return new NewTopic("example", 1, Short.valueOf("1"));
    }
}

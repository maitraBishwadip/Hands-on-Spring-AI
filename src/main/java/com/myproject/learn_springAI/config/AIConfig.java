package com.myproject.learn_springAI.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AIConfig {

    @Value("classpath:resources/prompttemplates/userpromt.st")
    Resource systemMessage;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        // Use the builder passed in by Spring Boot's auto-configuration
        return builder
                .defaultSystem(
                        systemMessage.getFilename()

                )
                .defaultUser("""
                        Hi , how can u help me ?
                        """)
                        .build();
    }
}


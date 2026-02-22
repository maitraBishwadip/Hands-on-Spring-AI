package com.myproject.learn_springAI.serice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor



public class AIService {

    private final ChatClient chatClient;

    public String getJoke(String topic)
    {
       return chatClient.prompt()
                .user("Tell me a joke about " + topic)
                .call()
                .content();
    }

}

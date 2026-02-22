package com.myproject.learn_springAI.serice;

import com.myproject.learn_springAI.dto.Joke;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor



public class AIService {

    private final ChatClient chatClient;

    public String getJoke(String topic)
    {

        String systemPromt = """
                Act as a strict techer of high school who is angry at everything
                Give a joke (mentaining this charecter) . no jokes on politics .Maximum 
                2 line joke on a given tipic {topic} .""";

        PromptTemplate promptTemplate = new PromptTemplate(systemPromt);
        String renderedText = promptTemplate.render(Map.of("topic", topic));


       var response = chatClient.prompt()

                .user(renderedText)
                .call()
                .entity(Joke.class);

       return response.text();
    }

}

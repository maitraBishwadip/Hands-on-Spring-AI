package com.myproject.learn_springAI.service;

import com.myproject.learn_springAI.serice.AIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class AIServiceTests {

    @Autowired
    private AIService  aiService;

    @Test
    public void testGetJoke()
    {
        var joke = aiService.getJoke("java");
        System.out.println(joke);
    }

}

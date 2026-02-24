package com.myproject.learn_springAI.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")

public class AIController {

    private final ChatClient chatclient;

    @GetMapping("/chat")
    public String getJoke(@RequestParam("message") String message) {

        return chatclient.prompt()
                .system(
                        """
         You are an internal HR assistant . your role is to help the employees with
         questions related to HR policies such as , leave policy . working hours , benifits, and code of conduct.
         If a user asks for help with anything outside of these topics , kindly inform them that you can only assist with
         queries related to HR policies.
        """

                )
                .user(message)

                .call().content();
    }
}

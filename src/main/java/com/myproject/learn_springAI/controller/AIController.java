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

        return chatclient.prompt(message).call().content();
    }
}

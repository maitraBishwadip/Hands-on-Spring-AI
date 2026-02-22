package com.myproject.learn_springAI.dto;

public record Joke(
        String text,
        String category,
        Double laughScore,
        Boolean isNSFW
) {

}

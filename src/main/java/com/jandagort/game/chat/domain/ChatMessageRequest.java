package com.jandagort.game.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class ChatMessageRequest {
    @Size(min = 1)
    private String content;
}
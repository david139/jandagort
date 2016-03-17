package com.jandagort.game.chat.domain;

import javax.validation.constraints.Size;

public class ChatMessageRequest {
    @Size(min = 1)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

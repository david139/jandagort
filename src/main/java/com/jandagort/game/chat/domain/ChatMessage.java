package com.jandagort.game.chat.domain;

import com.jandagort.user.domain.UserEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatMessage {
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String MESSAGE_HTML_OPEN = " <span class='message-owner'>";
    public static final String MESSAGE_HTML_CLOSE = "</span>: ";

    private LocalDateTime timeSent;
    private UserEntity sender;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    public String writeAsHTML(){
        return formatLocalDateTime(this.getTimeSent(),TIME_FORMAT)
                + MESSAGE_HTML_OPEN + this.getSender().getUsername()
                + MESSAGE_HTML_CLOSE + this.getContent();
    }

    private String formatLocalDateTime(LocalDateTime input, String pattern) {
        return input.format(DateTimeFormatter.ofPattern(pattern));
    }
}
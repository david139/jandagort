package com.jandagort.game.chat.domain;

import com.jandagort.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatMessage {
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String MESSAGE_HTML_OPEN = " <span class='message-owner'>";
    private static final String MESSAGE_HTML_CLOSE = "</span>: ";

    private LocalDateTime timeSent;
    private UserEntity sender;
    private String content;

    public String writeAsHTML(){
        return formatLocalDateTime(this.getTimeSent(),TIME_FORMAT)
                + MESSAGE_HTML_OPEN + this.getSender().getUsername()
                + MESSAGE_HTML_CLOSE + this.getContent();
    }

    private String formatLocalDateTime(LocalDateTime input, String pattern) {
        return input.format(DateTimeFormatter.ofPattern(pattern));
    }
}
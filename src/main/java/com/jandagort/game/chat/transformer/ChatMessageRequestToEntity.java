package com.jandagort.game.chat.transformer;

import com.jandagort.game.chat.domain.ChatMessageEntity;
import com.jandagort.game.chat.domain.ChatMessageRequest;
import com.jandagort.user.domain.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

import java.time.LocalDateTime;

@Component
public class ChatMessageRequestToEntity {
    public ChatMessageEntity transform(ChatMessageRequest request, UserEntity user){
        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setContent(HtmlUtils.htmlEscape(request.getContent()));
        entity.setSender(user);
        entity.setTimeSent(LocalDateTime.now());
        return entity;
    }
}

package com.jandagort.game.chat.transformer;

import com.jandagort.game.chat.domain.ChatMessage;
import com.jandagort.game.chat.domain.ChatMessageEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatMessageEntityToMessage {

    public List<ChatMessage> transformAll(List<ChatMessageEntity> entities){
        ArrayList<ChatMessage> results = new ArrayList<>();
        entities.stream().forEach((entity) -> results.add(transform(entity)));
        return results;
    }

   public ChatMessage transform(ChatMessageEntity entity){
       ChatMessage message = new ChatMessage();
       message.setContent(entity.getContent());
       message.setSender(entity.getSender());
       message.setTimeSent(entity.getTimeSent());
       return message;
   }
}

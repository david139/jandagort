package com.jandagort.game.chat.repository;

import com.jandagort.game.chat.domain.ChatMessage;
import com.jandagort.game.chat.domain.ChatMessageEntity;
import com.jandagort.game.chat.domain.ChatMessageRequest;
import com.jandagort.game.chat.transformer.ChatMessageEntityToMessage;
import com.jandagort.game.chat.transformer.ChatMessageRequestToEntity;
import com.jandagort.user.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    ChatDao dao;

    @Autowired
    ChatMessageRequestToEntity requestToEntity;

    @Autowired
    ChatMessageEntityToMessage entityToMessage;

    public ChatMessage save(ChatMessageRequest request, UserEntity user){
        ChatMessageEntity entity = requestToEntity.transform(request, user);
        dao.save(entity);
        return entityToMessage.transform(entity);
    }

    public List<ChatMessage> getRecentChatMessages(){
        List<ChatMessageEntity> entities = dao.findRecentMessages(LocalDateTime.now().minusHours(8));
        return entityToMessage.transformAll(entities);
    }

}

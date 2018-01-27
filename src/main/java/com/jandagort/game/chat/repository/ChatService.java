package com.jandagort.game.chat.repository;

import com.jandagort.game.chat.domain.ChatMessage;
import com.jandagort.game.chat.domain.ChatMessageEntity;
import com.jandagort.game.chat.domain.ChatMessageRequest;
import com.jandagort.game.chat.transformer.ChatMessageEntityToMessage;
import com.jandagort.game.chat.transformer.ChatMessageRequestToEntity;
import com.jandagort.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ChatService {
    private ChatDao dao;
    private ChatMessageRequestToEntity requestToEntity;
    private ChatMessageEntityToMessage entityToMessage;

    public ChatMessage save(ChatMessageRequest request, UserEntity user) {
        ChatMessageEntity entity = requestToEntity.transform(request, user);
        dao.save(entity);
        return entityToMessage.transform(entity);
    }

    public List<ChatMessage> getRecentChatMessages() {
        List<ChatMessageEntity> entities = dao.findRecentMessages(LocalDateTime.now().minusHours(8));
        return entityToMessage.transformAll(entities);
    }

}

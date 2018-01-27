package com.jandagort.game.chat.repository;

import com.jandagort.game.chat.domain.ChatMessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatDao extends CrudRepository<ChatMessageEntity, Long> {
    @Query(value = "SELECT c FROM ChatMessageEntity c WHERE c.timeSent > :threshold")
    List<ChatMessageEntity> findRecentMessages(@Param("threshold") LocalDateTime threshold);
}

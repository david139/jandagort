package com.jandagort.game.chat.domain;

import com.jandagort.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chatmessages", schema = "Jandagort")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime timeSent;

    @ManyToOne
    private UserEntity sender;

    private String content;
}

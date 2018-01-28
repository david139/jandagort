package com.jandagort.user.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String username;
    private String password;
    private boolean emailActivated;
    private LocalDateTime lastLogin;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity(String email, String username, String password) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.emailActivated = false;
        this.lastLogin = LocalDateTime.now();
        this.role = UserRole.USER;

    }
}



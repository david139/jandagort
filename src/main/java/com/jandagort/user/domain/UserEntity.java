package com.jandagort.user.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
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

    public UserEntity(){}

    public UserEntity(String email, String username, String password) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.emailActivated = false;
        this.lastLogin = LocalDateTime.now();
        this.role = UserRole.USER;

    }

    public UserEntity(String email, boolean emailActivated, LocalDateTime lastLogin, String password, UserRole role, String username) {
        this.email = email;
        this.emailActivated = emailActivated;
        this.lastLogin = lastLogin;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailActivated() {
        return emailActivated;
    }

    public void setEmailActivated(boolean emailActivated) {
        this.emailActivated = emailActivated;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}



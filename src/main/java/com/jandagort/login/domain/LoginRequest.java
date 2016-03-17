package com.jandagort.login.domain;

import com.jandagort.register.domain.RegisterRequest;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginRequest {

    @Pattern(regexp = RegisterRequest.EMAIL_REGEX)
    private String email;

    @Size(min = RegisterRequest.MIN_PASSWORD_LENGTH)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.jandagort.login.domain;

import com.jandagort.register.domain.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    @Pattern(regexp = RegisterRequest.EMAIL_REGEX)
    private String email;

    @Size(min = RegisterRequest.MIN_PASSWORD_LENGTH)
    private String password;
    
}

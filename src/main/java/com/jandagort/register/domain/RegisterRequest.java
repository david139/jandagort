package com.jandagort.register.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final int MIN_PASSWORD_LENGTH = 4;
    private static final int MIN_USERNAME_LENGTH = 4;

    @NotNull
    @Pattern(regexp = EMAIL_REGEX)
    private String email;

    @NotNull
    @Size(min = MIN_USERNAME_LENGTH)
    private String username;

    @NotNull
    @Size(min = MIN_PASSWORD_LENGTH)
    private String password;

    @NotNull
    @Size(min = MIN_PASSWORD_LENGTH)
    private String confirmPassword;

}

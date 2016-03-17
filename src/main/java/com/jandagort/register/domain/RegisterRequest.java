package com.jandagort.register.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterRequest {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final int MIN_USERNAME_LENGTH = 4;
    public static final int MIN_PASSWORD_LENGTH = 4;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    boolean isValid(){
        return password.equals(confirmPassword);
    }

}

package com.jandagort.register.transformer;

import com.jandagort.user.domain.UserEntity;
import com.jandagort.register.domain.RegisterRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterRequestToUser {

    public UserEntity transform(RegisterRequest request) {
        return new UserEntity(request.getEmail(), request.getUsername(), request.getPassword());
    }

    public List<UserEntity> transformAll(List<RegisterRequest> requests) {
        ArrayList<UserEntity> users = new ArrayList<UserEntity>();
        for (RegisterRequest registerRequest : requests) {
            users.add(transform(registerRequest));
        }
        return users;
    }

}

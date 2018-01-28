package com.jandagort.user.repository;


import com.jandagort.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepo;

    public UserEntity save(UserEntity user) {
        return userRepo.save(user);
    }

    public UserEntity login(String email, String password) {
        return userRepo.findOneByEmailAndPassword(email, password);
    }

    public UserEntity getByEmail(String email) {
        return userRepo.findOneByEmail(email);
    }

    public UserEntity getByUsername(String username) {
        return userRepo.findOneByUsername(username);
    }
}

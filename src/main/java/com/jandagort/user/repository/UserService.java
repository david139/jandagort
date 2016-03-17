package com.jandagort.user.repository;


import com.jandagort.user.domain.UserEntity;
import com.jandagort.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity find(long id) {
        return userRepo.findOne(id);
    }

    public void save(UserEntity user) {
        userRepo.save(user);
    }

    public UserEntity login(String email, String password) {
        return userRepo.findOneByEmailAndPassword(email, password);
    }

    public UserEntity getByEmail(String email){return userRepo.findOneByEmail(email);}

    public UserEntity getByUsername(String username){return userRepo.findOneByUsername(username);}
}

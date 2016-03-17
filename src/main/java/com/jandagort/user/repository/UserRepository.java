package com.jandagort.user.repository;

import com.jandagort.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public UserEntity findOneByEmailAndPassword(String username, String password);
    public UserEntity findOneByEmail(String email);
    public UserEntity findOneByUsername(String username);
}

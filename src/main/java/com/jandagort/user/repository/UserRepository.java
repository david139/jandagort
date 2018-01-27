package com.jandagort.user.repository;

import com.jandagort.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findOneByEmailAndPassword(String username, String password);

    UserEntity findOneByEmail(String email);

    UserEntity findOneByUsername(String username);
}

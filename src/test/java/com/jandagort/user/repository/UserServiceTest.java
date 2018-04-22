package com.jandagort.user.repository;


import com.jandagort.user.domain.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService underTest;

    @Before
    public void setUp() {
        underTest = new UserService(userRepository);
    }

    @Test
    public void saveShouldSaveInRepository() {
        // Given
        UserEntity userEntity = new UserEntity();

        // When
        underTest.save(userEntity);

        // Then
        verify(userRepository).save(userEntity);
    }

    @Test
    public void loginShouldFindUserEntityByEmailAndPassword() {
        // Given
        String email = "email";
        String password = "password";
        UserEntity expected = new UserEntity();
        when(userRepository.findOneByEmailAndPassword(email, password)).thenReturn(expected);


        // When
        UserEntity actual = underTest.login(email, password);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getByEmailShouldGetFromRepoByEmail() {
        // Given
        String email = "email";
        UserEntity expected = new UserEntity();
        when(userRepository.findOneByEmail(email)).thenReturn(expected);


        // When
        UserEntity actual = underTest.getByEmail(email);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getByUsernameShouldGetFromRepoByUsername() {
        // Given
        String username = "username";
        UserEntity expected = new UserEntity();
        when(userRepository.findOneByUsername(username)).thenReturn(expected);


        // When
        UserEntity actual = underTest.getByUsername(username);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
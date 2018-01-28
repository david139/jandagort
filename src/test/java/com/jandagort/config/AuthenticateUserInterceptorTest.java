package com.jandagort.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jandagort.game.empire.controller.EmpireController.EMPIRE_MAPPING;
import static com.jandagort.login.controller.LoginController.LOGIN_MAPPING;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticateUserInterceptorTest {

    private AuthenticateUserInterceptor underTest;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() {
        underTest = new AuthenticateUserInterceptor();
    }

    @Test
    public void shouldRedirectToLoginPageIfSessionIsNull() throws Exception {
        // Given
        when(request.getRequestURI()).thenReturn("/game/test");
        when(request.getSession().getAttribute("user")).thenReturn(null);

        // When
        underTest.preHandle(request, response, null);

        // Then
        verify(response).sendRedirect(LOGIN_MAPPING);
    }

    @Test
    public void shouldRedirectGameIfSessionExists() throws Exception {
        // Given
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getSession().getAttribute("user")).thenReturn(new Object());

        // When
        underTest.preHandle(request, response, null);

        // Then
        verify(response).sendRedirect(EMPIRE_MAPPING);
    }
}
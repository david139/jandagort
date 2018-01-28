package com.jandagort.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticateUserInterceptorTest {

    private AuthenticateUserInterceptor underTest;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() {
        underTest = new AuthenticateUserInterceptor();
    }

    @Test
    public void test() throws Exception {
        underTest.preHandle(request, response, null);
    }
}
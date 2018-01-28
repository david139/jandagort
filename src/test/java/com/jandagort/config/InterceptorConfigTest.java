package com.jandagort.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InterceptorConfigTest {

    @Mock
    private InterceptorRegistry interceptorRegistry;

    @Mock
    private AuthenticateUserInterceptor authenticateUserInterceptor;

    private InterceptorConfig underTest;

    @Before
    public void setUp(){
        underTest = new InterceptorConfig(authenticateUserInterceptor);
    }

    @Test
    public void shouldAddAuthenticateUserInterceptor(){
        // When
        underTest.addInterceptors(interceptorRegistry);

        // Then
        verify(interceptorRegistry).addInterceptor(authenticateUserInterceptor);
    }

}
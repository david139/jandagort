package com.jandagort.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WebSocketConfigTest {

    @Mock
    private StompEndpointRegistry stompEndpointRegistry;

    @Mock
    private StompWebSocketEndpointRegistration stompWebSocketEndpointRegistration;

    @Mock
    private MessageBrokerRegistry messageBrokerRegistry;

    private WebSocketConfig underTest;

    @Before
    public void setUp() {
        underTest = new WebSocketConfig();
    }

    @Test
    public void registerStompEndpoints() {
        // Given
        when(stompEndpointRegistry.addEndpoint(any())).thenReturn(stompWebSocketEndpointRegistration);

        // When
        underTest.registerStompEndpoints(stompEndpointRegistry);

        // Then
        verify(stompEndpointRegistry).addEndpoint("/chatsocket");
        verify(stompWebSocketEndpointRegistration).withSockJS();
    }

    @Test
    public void configureMessageBroker() {
        // When
        underTest.configureMessageBroker(messageBrokerRegistry);

        // Then
        verify(messageBrokerRegistry).enableSimpleBroker("/chat");
        verify(messageBrokerRegistry).setApplicationDestinationPrefixes("/game");
    }
}
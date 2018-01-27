package com.jandagort.game.chat.controller;

import com.jandagort.game.chat.domain.ChatMessage;
import com.jandagort.game.chat.domain.ChatMessageRequest;
import com.jandagort.game.chat.repository.ChatService;
import com.jandagort.config.WebSocketConfig;
import com.jandagort.user.domain.UserEntity;
import com.jandagort.util.SessionUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/game")
@AllArgsConstructor
public class ChatController {
    private static final String CHAT_MAPPING = "/chat";
    private static final String CHAT_VIEW = "chat";
    private static final String PUBLIC_CHANNEL_NAME = "/public";

    private SimpMessagingTemplate template;
    private ChatService service;

    @RequestMapping(value = CHAT_MAPPING, method = RequestMethod.GET)
    public ModelAndView chatSite() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("messages", service.getRecentChatMessages());
        mav.setViewName(CHAT_VIEW);
        return mav;
    }

    @RequestMapping(value = CHAT_MAPPING, method = RequestMethod.POST)
    public void getMessage(@Valid @ModelAttribute ChatMessageRequest message,
                           HttpServletResponse response, HttpServletRequest request) {
        UserEntity user = SessionUtil.getSessionUser(request);
        ChatMessage savedMessage = service.save(message, user);
        pushMessageIntoSocket(savedMessage);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void pushMessageIntoSocket(ChatMessage message) {
        template.convertAndSend(WebSocketConfig.CHAT_SOCKET_OUT + PUBLIC_CHANNEL_NAME,
                message.writeAsHTML());
    }
}

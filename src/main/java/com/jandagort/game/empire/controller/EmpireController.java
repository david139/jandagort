package com.jandagort.game.empire.controller;

import com.jandagort.user.domain.UserEntity;
import com.jandagort.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/game")
@Slf4j
public class EmpireController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpireController.class);
    private static final String EMPIRE_MAPPING = "/empire";
    private static final String EMPIRE_VIEW = "empire";

    @RequestMapping("/")
    public String emptyPath(){
        return "redirect:/login";
    }

    @RequestMapping(EMPIRE_MAPPING)
    public ModelAndView empire(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        UserEntity user = SessionUtil.getSessionUser(request);
        log.info("Empire page called by " + user.getUsername());

        mav.addObject("user", user);
        mav.setViewName(EMPIRE_VIEW);
        return mav;
    }
}

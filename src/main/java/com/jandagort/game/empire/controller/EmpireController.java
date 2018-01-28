package com.jandagort.game.empire.controller;

import com.jandagort.game.economy.planet.repository.PlanetService;
import com.jandagort.user.domain.UserEntity;
import com.jandagort.user.SessionUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
@AllArgsConstructor
public class EmpireController {
    public static final String EMPIRE_MAPPING = "/game/empire";
    private static final String EMPIRE_VIEW = "empire";

    private PlanetService planetService;

    @RequestMapping(EMPIRE_MAPPING)
    public ModelAndView empire(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        UserEntity user = SessionUtil.getSessionUser(request);
        log.info("Empire page called by " + user.getUsername());

        mav.addObject("user", user);
        mav.addObject("planet", planetService.getByOwner(user));
        mav.setViewName(EMPIRE_VIEW);
        return mav;
    }
}

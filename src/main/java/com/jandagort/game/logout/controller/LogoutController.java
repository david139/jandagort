package com.jandagort.game.logout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/game")
public class LogoutController {
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        request.getSession().removeAttribute("user");
        mav.setViewName("redirect:/login");
        return mav;
    }
}

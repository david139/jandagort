package com.jandagort.game.profile;


import com.jandagort.user.domain.UserEntity;
import com.jandagort.util.SessionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/game")
public class ProfileController {

    private static final String PROFILE_MAPPING = "/profile";
    private static final String PROFILE_VIEW = "profile";

    @RequestMapping(PROFILE_MAPPING)
    public ModelAndView profileSite(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        UserEntity user = SessionUtil.getSessionUser(request);

        mav.addObject("user", user);
        mav.setViewName(PROFILE_VIEW);
        return mav;
    }

}

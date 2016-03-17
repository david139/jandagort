package com.jandagort.login.controller;

import com.jandagort.login.domain.LoginRequest;
import com.jandagort.user.domain.UserEntity;
import com.jandagort.user.repository.UserService;
import com.jandagort.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    public static final String LOGIN_MAPPING = "/login";
    public static final String LOGIN_VIEW = "login";
    public static final String REDIRECT_GAME_EMPIRE = "redirect:game/empire";
    public static final String INVALID_EMAIL_ERROR_KEY = "emailError";
    public static final String INVALID_EMAIL_ERROR_TEXT = "Hibás e-mail formátum.";
    public static final String INVALID_PASSWORD_ERROR_KEY = "passwordError";
    public static final String INVALID_PASSWORD_ERROR_TEXT = "Túl rövid jelszó, minimum 4 karakter.";
    public static final String WRONG_CREDENTIALS_ERROR_KEY = "not_exist";
    public static final String WRONG_CREDENTIALS_ERROR_VALUE = "Hibás e-mail cím vagy jelszó.";

    @Autowired
    UserService userService;

    @RequestMapping(value = LOGIN_MAPPING, method = RequestMethod.GET)
    public String shogLoginSite(LoginRequest loginRequest) {
        return LOGIN_VIEW;
    }

    @RequestMapping(value = LOGIN_MAPPING, method = RequestMethod.POST)
    public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response,
                                  @Valid @ModelAttribute LoginRequest loginRequest,
                                  BindingResult bindingResult) {

        ModelAndView mvm = new ModelAndView();
        LOGGER.info(bindingResult.toString());

        if (bindingResult.hasErrors()) {
            returnToViewWithErrorMessages(mvm);
        } else {
            UserEntity user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            if (user == null) {
                returnToViewWithWrongCredentialsMessage(mvm);
            } else {
                setSessionAndRedirect(request, mvm, user);
            }
        }
        return mvm;
    }

    private void setSessionAndRedirect(HttpServletRequest request, ModelAndView mvm, UserEntity user) {
        request.getSession().setAttribute(SessionUtil.USER_SESSION_KEY, user);
        mvm.setViewName(REDIRECT_GAME_EMPIRE);
    }

    private void returnToViewWithWrongCredentialsMessage(ModelAndView mvm) {
        mvm.setViewName(LOGIN_VIEW);
        mvm.addObject(WRONG_CREDENTIALS_ERROR_KEY, WRONG_CREDENTIALS_ERROR_VALUE);
    }

    private void returnToViewWithErrorMessages(ModelAndView mvm) {
        mvm.addObject(INVALID_EMAIL_ERROR_KEY, INVALID_EMAIL_ERROR_TEXT);
        mvm.addObject(INVALID_PASSWORD_ERROR_KEY, INVALID_PASSWORD_ERROR_TEXT);
        mvm.setViewName(LOGIN_VIEW);
    }

}

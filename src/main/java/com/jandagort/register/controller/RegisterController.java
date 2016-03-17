package com.jandagort.register.controller;

import com.jandagort.login.controller.LoginController;
import com.jandagort.login.domain.LoginRequest;
import com.jandagort.user.domain.UserEntity;
import com.jandagort.register.domain.RegisterRequest;
import com.jandagort.register.transformer.RegisterRequestToUser;
import com.jandagort.user.repository.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class RegisterController {
    public static final String REGISTER_SUCCESS_ALERT_TEXT = "Sikeres regisztráció, most már bejelentkezhet.";
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
    public static final String REGISTER_MAPPING = "/register";
    public static final String REGISTER_VIEW = "register";
    public static final String REGISTER_SUCCESS_ALERT_KEY = "register_success";
    public static final String INVALID_EMAIL_ERROR_KEY = "emailError";
    public static final String INVALID_EMAIL_ERROR_TEXT = "Hibás e-mail formátum.";
    public static final String INVALID_PASSWORD_ERROR_KEY = "passwordError";
    public static final String INVALID_PASSWORD_ERROR_TEXT = "Túl rövid jelszó, minimum 4 karakter.";
    public static final String INVALID_USERNAME_ERROR = "usernameError";
    public static final String INVALID_USERNAME_TEXT = "Túl rövid felhasználónév.";
    public static final String PASSWORDS_NOT_EQUAL_ERROR_KEY = "passwords_not_equal";
    public static final String PASSWORDS_NOT_EQUAL_ERROR_TEXT = "A jelszó és az ellenőrző jelszó nem egyeznek meg.";
    public static final String EMAIL_IN_USE_ERROR_KEY = "email_in_use";
    public static final String EMAIL_IN_USE_ERROR_TEXT = "Az email cím már használatban van.";
    public static final String USERNAME_IN_USE_ERROR_KEY = "username_in_use";
    public static final String USERNAME_IN_USE_ERROR_TEXT = "Az felhasználónév már használatban van.";
    public static final String REDIRECT = "redirect:";

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterRequestToUser transformer;

    @RequestMapping(value = REGISTER_MAPPING, method = RequestMethod.GET)
    public String showRegisterSite(RegisterRequest registerRequest) {
        return REGISTER_VIEW;
    }

    @RequestMapping(value = REGISTER_MAPPING, method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,
                                     @Valid @ModelAttribute RegisterRequest registerRequest,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {

        ModelAndView mvm = new ModelAndView();

        if (bindingResult.hasErrors()) {
            prepareBindingErrorsView(mvm);
        } else {
            if (registerRequestIsValid(registerRequest, mvm)) {
                registerUser(registerRequest);
                redirectToLoginView(mvm, redirectAttributes);
            } else {
                mvm.setViewName(REGISTER_VIEW);
            }
        }
        return mvm;
    }

    private void redirectToLoginView(ModelAndView mvm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(REGISTER_SUCCESS_ALERT_KEY, REGISTER_SUCCESS_ALERT_TEXT);
        mvm.setViewName(REDIRECT + LoginController.LOGIN_VIEW);
    }

    private void registerUser(RegisterRequest registerRequest) {
        UserEntity user = transformer.transform(registerRequest);
        userService.save(user);
    }

    private boolean registerRequestIsValid(RegisterRequest registerRequest, ModelAndView mav) {
        boolean passwordError = checkIfPasswordsEqual(registerRequest, mav);
        boolean emailError = checkIfEmailIsAlreadyInUse(registerRequest, mav);
        boolean usernameError = checkIfUsernameAlreadyInUse(registerRequest, mav);

        return passwordError && emailError && usernameError;
    }

    private boolean checkIfUsernameAlreadyInUse(RegisterRequest registerRequest, ModelAndView mvm) {
        boolean hadErrors = true;
        if (usernameAlreadyInUse(registerRequest)) {
            mvm.addObject(USERNAME_IN_USE_ERROR_KEY, USERNAME_IN_USE_ERROR_TEXT);
            hadErrors = false;
        }
        return hadErrors;
    }

    private boolean checkIfEmailIsAlreadyInUse(RegisterRequest registerRequest, ModelAndView mvm) {
        boolean hadErrors = true;
        if (emailAlreadyInUse(registerRequest)) {
            mvm.addObject(EMAIL_IN_USE_ERROR_KEY, EMAIL_IN_USE_ERROR_TEXT);
            hadErrors = false;
        }
        return hadErrors;
    }

    private boolean checkIfPasswordsEqual(RegisterRequest registerRequest, ModelAndView mvm) {
        boolean hadErrors = true;
        if (passwordsNotEqual(registerRequest)) {
            mvm.addObject(PASSWORDS_NOT_EQUAL_ERROR_KEY, PASSWORDS_NOT_EQUAL_ERROR_TEXT);
            hadErrors = false;
        }
        return hadErrors;
    }

    private boolean usernameAlreadyInUse(RegisterRequest registerRequest) {
        return userService.getByUsername(registerRequest.getUsername()) != null;
    }

    private boolean emailAlreadyInUse(RegisterRequest registerRequest) {
        return userService.getByEmail(registerRequest.getEmail()) != null;
    }

    private boolean passwordsNotEqual(RegisterRequest registerRequest) {
        return !registerRequest.getPassword().equals(registerRequest.getConfirmPassword());
    }

    private void prepareBindingErrorsView(ModelAndView mvm) {
        mvm.addObject(INVALID_EMAIL_ERROR_KEY, INVALID_EMAIL_ERROR_TEXT);
        mvm.addObject(INVALID_PASSWORD_ERROR_KEY, INVALID_PASSWORD_ERROR_TEXT);
        mvm.addObject(INVALID_USERNAME_ERROR, INVALID_USERNAME_TEXT);
        mvm.setViewName(REGISTER_VIEW);
    }
}


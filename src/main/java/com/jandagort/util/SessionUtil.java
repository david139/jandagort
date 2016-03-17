package com.jandagort.util;

import com.jandagort.user.domain.UserEntity;

import javax.servlet.http.HttpServletRequest;

public abstract class SessionUtil {
    private SessionUtil(){}
    public static final String USER_SESSION_KEY = "user";

    public static UserEntity getSessionUser(HttpServletRequest request){
        return (UserEntity) request.getSession().getAttribute(USER_SESSION_KEY);
    }
}

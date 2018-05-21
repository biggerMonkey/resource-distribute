package com.resource.distribute.dto;

import com.resource.distribute.entity.User;

/**
 * @author huangwenjun
 * @version 2018年1月21日 下午11:21:51
 */
public class LoginRes {
    private String token;
    private User userInfo;

    public LoginRes() {
        super();
    }

    public LoginRes(String token, User userInfo) {
        super();
        this.token = token;
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "LoginRes [token=" + token + ", userInfo=" + userInfo + "]";
    }
}

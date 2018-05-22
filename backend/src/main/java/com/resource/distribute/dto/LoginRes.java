package com.resource.distribute.dto;

import java.util.Date;

import com.resource.distribute.entity.User;

/**
 * @author huangwenjun
 * @version 2018年1月21日 下午11:21:51
 */
public class LoginRes {
    private String token;
    private String mobileJobNum;
    private User userInfo;
    private Date loginTime;

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

    public String getMobileJobNum() {
        return mobileJobNum;
    }

    public void setMobileJobNum(String mobileJobNum) {
        this.mobileJobNum = mobileJobNum;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginRes [token=" + token + ", mobileJobNum=" + mobileJobNum + ", userInfo="
                + userInfo + "]";
    }
}

package com.resource.distribute.utils;

import java.util.Objects;

import org.springframework.util.StringUtils;

import com.resource.distribute.common.Constant;
import com.resource.distribute.dto.LoginRes;
import com.resource.distribute.entity.User;

public class AuthCurrentUser {
    private static ThreadLocal<LoginRes> currentUser = new ThreadLocal<LoginRes>();

    public static void set(LoginRes user) {
        currentUser.set(user);
    }

    public static LoginRes get() {
        return currentUser.get();
    }

    public static void remove() {
        currentUser.remove();
    }


    public static int getUserId() {
        LoginRes userInfo = get();
        if (userInfo == null) {
            return 0;
        }
        if (Objects.isNull(userInfo)) {
            throw new NullPointerException();
        }
        return userInfo.getUserInfo().getId();
    }

    public static boolean isManager() {
        if (get().getUserInfo().getRoleType() == Constant.USER.ADMIN) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDepartManager() {
        if (get().getUserInfo().getRoleType() == Constant.USER.DEPARTMENT_ADMIN) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isCountUser() {
        if (get().getUserInfo().getRoleType() == Constant.USER.COUNT_USER) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOrdinaryUser() {
        if (get().getUserInfo().getRoleType() == Constant.USER.ORDINARY) {
            return true;
        } else {
            return false;
        }
    }

    public static User getUserInfo() {
        return get().getUserInfo();
    }

    public static Integer getDepartMentId() {
        if (StringUtils.isEmpty(getUserInfo().getDevId())) {
            return 0;
        } else {
            return getUserInfo().getDevId();
        }
    }

    public static String getMobileJobNum() {
        if (StringUtils.isEmpty(get().getMobileJobNum())) {
            return "";
        } else {
            return get().getMobileJobNum();
        }
    }
}

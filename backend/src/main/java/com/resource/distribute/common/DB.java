package com.resource.distribute.common;

import java.util.concurrent.ConcurrentHashMap;

import com.resource.distribute.dto.LoginRes;


/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class DB {
    public static String maxUserJobNumber = "";
    public static ConcurrentHashMap<String, LoginRes> users =
            new ConcurrentHashMap<String, LoginRes>();
}

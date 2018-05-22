package com.resource.distribute.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.DB;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.LoginRes;
import com.resource.distribute.service.UserService;

public class LoginHandleInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(LoginHandleInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String token = request.getHeader(Constant.USER.TOKEN);
        if (StringUtils.isEmpty(token)) {
            response(response, CodeEnum.NO_LOGIN, null);
            return false;
        }
        LoginRes loginRes = DB.users.get(token);
        if (loginRes == null) {
            response(response, CodeEnum.NO_LOGIN, null);
            return false;
        }
        String mobileJonNumber = loginRes.getMobileJobNum();
        ReturnInfo returnInfo = userService.checkMobile(token, mobileJonNumber);
        if (returnInfo.getCode() != CodeEnum.SUCCESS.getCode()) {
            response(response, returnInfo);
            return false;
        }
        loginRes.setLoginTime(new Date());
        DB.users.put(token, loginRes);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        // AuthCurrentUser.remove();
    }

    private void response(HttpServletResponse response, CodeEnum codeEnum, Object data)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Content-Type", "application/json");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ReturnInfo.create(codeEnum.getCode(), codeEnum.getMsg(), data,
                null)));
        out.flush();
    }

    private void response(HttpServletResponse response, ReturnInfo returnInfo) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Content-Type", "application/json");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnInfo));
        out.flush();
    }
}

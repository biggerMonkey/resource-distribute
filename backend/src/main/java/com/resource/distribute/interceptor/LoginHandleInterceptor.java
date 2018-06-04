package com.resource.distribute.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.DB;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.LoginRes;
import com.resource.distribute.utils.AuthCurrentUser;

public class LoginHandleInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(LoginHandleInterceptor.class);


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
        // if (!loginRes.getUserInfo().getRoleType().equals(Constant.USER.ADMIN)) {
        // String mobileJonNumber = loginRes.getMobileJobNum();
        // if (StringUtils.isEmpty(mobileJonNumber)) {
        // response(response, CodeEnum.NO_LOGIN, null);
        // return false;
        // }
        // MobileJobNumberDao mobileDao =
        // (MobileJobNumberDao) SpringContextUtil.getBean(MobileJobNumberDao.class);
        // Example example = new Example(MobileJobNumber.class);
        // example.createCriteria().andEqualTo("mobileJobNumber", mobileJonNumber);
        // List<MobileJobNumber> mobileJobNumbers = mobileDao.selectByExample(example);
        // if (mobileJobNumbers == null || mobileJobNumbers.size() != 1) {
        // response(response, CodeEnum.MOBILE_JOB_NUM_ERROR, null);
        // return false;
        // }
        // loginRes.setMobileJobNum(mobileJonNumber);
        // }
        Calendar cal = Calendar.getInstance();
        cal.setTime(loginRes.getLoginTime());
        long oldTime = cal.getTimeInMillis();
        cal.setTime(new Date());
        long newTime = cal.getTimeInMillis();

        long betweenHours = (newTime - oldTime) / Constant.TIME.oneHourMillisecond;
        if (betweenHours > 1) {
            response(response, CodeEnum.NO_LOGIN, null);
            return false;
        }
        loginRes.setLoginTime(new Date());
        DB.users.put(token, loginRes);
        AuthCurrentUser.set(loginRes);
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

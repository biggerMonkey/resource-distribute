package com.resource.distribute.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;

/**
 * @author huangwenjun
 * @Datetime 2017年8月8日
 */


@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(Exception.class)
    public ReturnInfo exceptionHandler(Exception exception) {
        LOG.error(exception.getMessage(), exception);
        return ReturnInfo.create(CodeEnum.SERVER_ERROR);
    }
}

package com.resource.distribute.utils;

import org.slf4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import strman.Strman;

import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;

/**
 * <p>
 * Description
 * </p>
 * <p>
 *
 * @author lengrongfu
 * @create 2017年12月11日上午11:36
 * @see </P>
 */
public class ValidateLogUtils {

    public static ReturnInfo paramError(BindingResult bindingResult, Logger log) {
        String s = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            System.out.println(fieldError);
            String filed =
                    Strman.append("参数校验失败：[", fieldError.getField(), ":",
                            fieldError.getDefaultMessage(), "]");
            if (s.isEmpty()) {
                s = filed;
                continue;
            }
            s = Strman.append(s, ",", filed);
        }
        log.info(s);
        return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR, s);
    }


    public static ReturnInfo paramError(String msg, Logger log) {
        log.info(msg);
        return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR, msg);
    }

}

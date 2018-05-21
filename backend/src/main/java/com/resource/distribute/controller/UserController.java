package com.resource.distribute.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.QueryUserReq;
import com.resource.distribute.entity.User;
import com.resource.distribute.service.UserService;
import com.resource.distribute.utils.ValidateLogUtils;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@RestController
@RequestMapping("/resource/user")
public class UserController {

    private static Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ReturnInfo addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return userService.addUser(user);
    }

    @PostMapping("/update")
    public ReturnInfo updateUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return userService.updateUser(user);
    }

    @GetMapping("/del/{user-id}")
    public ReturnInfo delUser(@PathVariable("user-id") Integer userId) {
        if (userId == null) {
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        return userService.delUser(userId);
    }

    @PostMapping("/query")
    public ReturnInfo listUsers(@RequestBody QueryUserReq queryUserReq) {
        return userService.listUsers(queryUserReq);
    }
}

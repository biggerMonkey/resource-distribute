package com.resource.distribute.service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.QueryUserReq;
import com.resource.distribute.entity.User;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface UserService {
    public ReturnInfo addUser(User user);

    public ReturnInfo updateUser(User user);

    public ReturnInfo delUser(Integer userId);

    public ReturnInfo listUsers(QueryUserReq queryUserReq);
}

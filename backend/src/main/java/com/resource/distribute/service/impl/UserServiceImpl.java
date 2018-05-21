package com.resource.distribute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.DB;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.UserDao;
import com.resource.distribute.dto.QueryUserReq;
import com.resource.distribute.entity.User;
import com.resource.distribute.service.UserService;
import com.resource.distribute.utils.AuthCurrentUser;
import com.resource.distribute.utils.MD5Util;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public synchronized ReturnInfo addUser(User user) {
        DB.maxUserJobNumber = String.valueOf(Integer.valueOf(DB.maxUserJobNumber) + 1);
        user.setJobNumber(DB.maxUserJobNumber);
        user.setPassword(MD5Util.getMD5Str(user.getPassword()));
        user.setIsDelete(null);
        user.setIsEnable(null);
        user.setRoleType(null);
        user.setCreateBy(AuthCurrentUser.getUserId());
        userDao.insertSelective(user);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo updateUser(User user) {
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(MD5Util.getMD5Str(user.getPassword()));
        }
        user.setRoleType(null);
        user.setUpdateBy(AuthCurrentUser.getUserId());
        userDao.updateByPrimaryKeySelective(user);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo delUser(Integer userId) {
        User user = new User();
        user.setId(userId);
        user.setIsDelete(Constant.USER.IS_DELETE);
        userDao.updateByPrimaryKeySelective(user);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo listUsers(QueryUserReq queryUserReq) {
        Example example = new Example(User.class);
        example.createCriteria().andLike("jobNumber", "%" + queryUserReq.getJobNumber() + "%")
                .andLike("userName", "%" + queryUserReq.getUserName() + "%")
                .andEqualTo("isDelete", Constant.USER.IS_NOT_DELETE);
        example.excludeProperties("password");
        PageHelper.startPage(queryUserReq.getPageNum(), queryUserReq.getPageSize());
        List<User> users = userDao.selectByExample(example);
        return ReturnInfo.createReturnSucces(users);
    }
}

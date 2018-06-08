package com.resource.distribute.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.DB;
import com.resource.distribute.common.PageNation;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.DepartmentDao;
import com.resource.distribute.dao.MobileJobNumberDao;
import com.resource.distribute.dao.UserDao;
import com.resource.distribute.dto.LoginReq;
import com.resource.distribute.dto.LoginRes;
import com.resource.distribute.dto.QueryUserReq;
import com.resource.distribute.dto.UserList;
import com.resource.distribute.entity.Department;
import com.resource.distribute.entity.MobileJobNumber;
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

    @Autowired
    private MobileJobNumberDao mobileDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public synchronized ReturnInfo addUser(User user) {
        DB.maxUserJobNumber = String.valueOf(Integer.valueOf(DB.maxUserJobNumber) + 1);
        user.setJobNumber(DB.maxUserJobNumber);
        user.setPassword(MD5Util.getMD5Str(user.getPassword()));
        user.setIsDelete(null);
        user.setCreateBy(AuthCurrentUser.getUserId());
        userDao.insertSelective(user);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo updateUser(User user) {
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(MD5Util.getMD5Str(user.getPassword()));
        }
        user.setJobNumber(null);
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
        PageHelper.startPage(queryUserReq.getPageNo(), queryUserReq.getPageSize());
        List<User> users = userDao.selectByExample(example);
        PageNation pageNation = ReturnInfo.create(users);
        List<Department> departments = null;
        if (!CollectionUtils.isEmpty(users)) {

            List<Integer> depIds = new ArrayList<>();
            users.forEach(item -> depIds.add(item.getDevId()));
            Example depExamp = new Example(Department.class);
            depExamp.createCriteria().andIn("id", depIds);
            departments = departmentDao.selectByExample(depExamp);
        }
        List<UserList> userListList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(departments)) {
            for (User user : users) {
                UserList userList = new UserList();
                BeanUtils.copyProperties(user, userList);
                for (Department department : departments) {
                    if (department.getId().equals(user.getDevId())) {
                        userList.setDepName(department.getDepName());
                    }
                }
                userListList.add(userList);
            }
        }
        return ReturnInfo.create(userListList, pageNation);
    }

    @Override
    public ReturnInfo login(LoginReq loginReq) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("jobNumber", loginReq.getJobNumber())
                .andEqualTo("isDelete", Constant.USER.IS_NOT_DELETE)
                .andEqualTo("isEnable", Constant.USER.IS_ENABLE);
        List<User> users = userDao.selectByExample(example);
        if (users == null || users.size() != 1) {
            return ReturnInfo.create(CodeEnum.LOGIN_FAIL);
        }
        User user = users.get(0);
        if (!user.getPassword().equals(MD5Util.getMD5Str(loginReq.getPassword()))) {
            return ReturnInfo.create(CodeEnum.LOGIN_FAIL);
        }
        for (LoginRes loginRes : DB.users.values()) {
            if (user.getId().equals(loginRes.getUserInfo().getId())) {
                DB.users.remove(loginRes.getToken());
            }
        }
        user.setPassword("");
        String token = UUID.randomUUID().toString();
        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        loginRes.setUserInfo(user);
        loginRes.setLoginTime(new Date());
        DB.users.put(token, loginRes);
        return ReturnInfo.createReturnSuccessOne(loginRes);
    }

    @Override
    public ReturnInfo checkMobile(String token, String mobileJonNumber) {
        LoginRes loginRes = DB.users.get(token);
        if (loginRes == null) {
            return ReturnInfo.create(CodeEnum.LOGIN_FAIL);
        }
        Example example = new Example(MobileJobNumber.class);
        example.createCriteria().andEqualTo("mobileJobNumber", mobileJonNumber);
        List<MobileJobNumber> mobileJobNumbers = mobileDao.selectByExample(example);
        if (mobileJobNumbers == null || mobileJobNumbers.size() != 1) {
            DB.users.remove(token);
            return ReturnInfo.create(CodeEnum.MOBILE_JOB_NUM_ERROR);
        }
        loginRes.setMobileJobNum(mobileJonNumber);
        DB.users.put(token, loginRes);
        return ReturnInfo.createReturnSuccessOne(loginRes);
    }
}

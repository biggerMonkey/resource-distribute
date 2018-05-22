package com.resource.distribute.dao;

import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;

import com.resource.distribute.entity.User;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface UserDao extends Mapper<User> {
    @Select("SELECT MAX(job_number) AS job_number FROM user")
    public String getMaxJobNo();
}

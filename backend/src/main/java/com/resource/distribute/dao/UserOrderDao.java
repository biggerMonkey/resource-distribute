package com.resource.distribute.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import com.resource.distribute.entity.UserOrder;

/**
 * @author huangwenjun
 * @version 2018年5月29日 下午10:43:45
 */
public interface UserOrderDao extends Mapper<UserOrder>, InsertListMapper<UserOrder> {

}

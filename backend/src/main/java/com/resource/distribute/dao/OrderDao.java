package com.resource.distribute.dao;

import com.resource.distribute.entity.MobileOrder;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:44:47
 */
public interface OrderDao extends Mapper<MobileOrder>, InsertListMapper<MobileOrder> {

}

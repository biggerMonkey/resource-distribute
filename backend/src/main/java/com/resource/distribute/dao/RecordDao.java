package com.resource.distribute.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;

import com.resource.distribute.entity.Record;

/**
 * @author huangwenjun
 * @version 2018年5月22日 下午10:59:25
 */
public interface RecordDao extends Mapper<Record> {

    @Select("SELECT * FROM record ORDER BY create_time DESC")
    public List<Record> selectAllRecord();

}

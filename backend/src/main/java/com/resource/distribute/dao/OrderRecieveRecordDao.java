package com.resource.distribute.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.resource.distribute.entity.OrderRecieveRecord;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author huangwenjun
 * @version 2018年7月28日 上午11:55:51
 */
public interface OrderRecieveRecordDao
        extends Mapper<OrderRecieveRecord>, InsertListMapper<OrderRecieveRecord> {

    @Insert("<script>INSERT INTO order_recieve_record (`order_id`,`hand_situation`,`receive_time`,`main_meal`,`second_meal`)"
            + "VALUES <foreach collection ='list' item='orderRecord' separator =','>"
            + "(#{orderRecord.orderId},#{orderRecord.handSituation}, #{orderRecord.receiveTime}, #{orderRecord.mainMeal}, #{orderRecord.secondMeal})</foreach >"
            + "ON DUPLICATE KEY UPDATE hand_situation=VALUES(hand_situation),receive_time=VALUES(receive_time),main_meal=VALUES(main_meal),"
            + "second_meal=VALUES(second_meal) </script>")
    public int insertListOnUpdate(List<OrderRecieveRecord> orderRecords);
}

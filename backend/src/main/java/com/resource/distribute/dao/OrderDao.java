package com.resource.distribute.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import com.resource.distribute.dto.OrderQueryReq;
import com.resource.distribute.dto.ReceiveOrderReq;
import com.resource.distribute.entity.MobileOrder;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:44:47
 */
public interface OrderDao extends Mapper<MobileOrder>, InsertListMapper<MobileOrder> {

    @Select("<script>SELECT * FROM mobile_order " + "<where>"
            + "<if test='queryReq.areaId != null'> " + " AND area_id=#{queryReq.areaId}" + "</if>"
            + "<if test='queryReq.handSituation != null'>"
            + "   AND hand_situation=#{queryReq.handSituation}" + "</if>"
            + "<if test='hadDial != null'>" + "   AND hand_situation !=#{hadDial}" + "</if>"
            + "<if test='queryReq.startTime != null'>"
            + "   AND update_time  &gt;= #{queryReq.startTime}" + "</if>"
            + "<if test='queryReq.endTime != null'>"
            + " AND update_time  &lt;  #{queryReq.endTime}</if>" + "<if test='roleType != null'>"
            + "   AND job_number = #{roleType} AND is_sensitive=1" + "</if> "
            + " </where>  ORDER BY create_time</script>")
    public List<MobileOrder> listOrder(@Param("queryReq") OrderQueryReq queryReq,
            @Param("roleType") String roleType, @Param("hadDial") String hadDial);


    @Select("<script>SELECT * FROM mobile_order "
            + "<where>"
            + "<if test='receiveOrderReq.areaId != null'> "
            + " AND area_id=#{receiveOrderReq.areaId} </if>"
            + "<if test='receiveOrderReq.mainMeal != null'>"
            + "   AND main_meal=#{receiveOrderReq.mainMeal} </if>"
            + "<if test='receiveOrderReq.secondMeal != null'>"
            + "   AND second_meal=#{receiveOrderReq.secondMeal} </if>"
            + "<if test='receiveOrderReq.broadband == 1'>"
            + "   AND broadband !='' </if>"
            + "<if test='receiveOrderReq.broadband == 2'>"
            + "   AND broadband ='' </if>"
            + "<if test='receiveOrderReq.mobileNumber != null'>"
            + "   AND mobile_number like concat(concat('%',#{receiveOrderReq.mobileNumber}),'%') </if> "
            + " AND job_number='' AND is_sensitive=1 AND hand_situation='待拨打' </where>  ORDER BY create_time</script>")
    public List<MobileOrder> recieveListOrder(
            @Param("receiveOrderReq") ReceiveOrderReq receiveOrderReq);

    @Select("SELECT DISTINCT main_meal FROM mobile_order")
    public List<String> getListMainMeal();

    @Select("SELECT DISTINCT second_meal FROM mobile_order")
    public List<String> getListSecondMeal();

}

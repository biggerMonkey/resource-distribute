package com.resource.distribute.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import com.resource.distribute.dto.CountReq;
import com.resource.distribute.dto.MobileOrderDto;
import com.resource.distribute.dto.OrderQueryReq;
import com.resource.distribute.dto.ReceiveOrderReq;
import com.resource.distribute.dto.UserOrderQueryInfo;
import com.resource.distribute.entity.MobileOrder;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:44:47
 */
public interface OrderDao extends Mapper<MobileOrder>, InsertListMapper<MobileOrder> {

    @Select("<script>SELECT * FROM mobile_order mo left JOIN user_order uo ON mo.`id`=uo.`order_id` "
            + "<where> <if test='queryReq.areaId != null'>  AND area_id=#{queryReq.areaId}</if>"
            + "<if test='jobNumber != null'>  AND job_number=#{jobNumber}</if>"
            + "<if test='queryReq.startTime != null'> AND receive_time &gt;= #{queryReq.startTime}</if>"
            + "<if test='queryReq.endTime != null'> AND receive_time &lt; #{queryReq.endTime}</if>"
            + "<if test='queryReq.handSituation != null'> AND hand_situation =#{queryReq.handSituation}</if>"
            + " AND mo.`is_sensitive`=1</where> ORDER BY mo.create_time </script>")
    public List<UserOrderQueryInfo> listWaitOrder(@Param("queryReq") OrderQueryReq queryReq,
            @Param("jobNumber") String jobNumber);

    @Select("<script>SELECT * FROM mobile_order mo left JOIN user_order uo ON mo.`id`=uo.`order_id` "
            + "<where> <if test='queryReq.areaId != null'>  AND area_id=#{queryReq.areaId}</if>"
            + "<if test='jobNumber != null'>  AND job_number=#{jobNumber}</if>"
            + "<if test='queryReq.startTime != null'>  AND receive_time &gt;= #{queryReq.startTime}</if>"
            + "<if test='queryReq.endTime != null'>  AND receive_time &lt; #{queryReq.endTime}</if>"
            + " AND hand_situation !='待拨打' AND mo.`is_sensitive`=1 </where> ORDER BY mo.create_time </script>")
    public List<UserOrderQueryInfo> listOtherOrder(@Param("queryReq") OrderQueryReq queryReq,
            @Param("jobNumber") String jobNumber);


    @Select("<script>SELECT DISTINCT mo.id AS tempId,mo.* FROM mobile_order mo LEFT JOIN user_order uo ON mo.id=uo.order_id "
            + "<where>"
            + "<if test='receiveOrderReq.areaId != null'> "
            + " AND mo.area_id=#{receiveOrderReq.areaId} </if>"
            + "<if test='receiveOrderReq.mainMeal != null'>"
            + "   AND mo.main_meal like #{receiveOrderReq.mainMeal} </if>"
            + "<if test='receiveOrderReq.secondMeal != null'>"
            + "   AND mo.second_meal like #{receiveOrderReq.secondMeal} </if>"
            + "<if test='receiveOrderReq.broadband == 1'>"
            + "   AND mo.broadband !='' </if>"
            + "<if test='receiveOrderReq.broadband == 2'>"
            + "   AND mo.broadband ='' </if>"
            + "<if test='receiveOrderReq.mobileNumber != null'>"
            + "   AND mobile_number like concat(concat('%',#{receiveOrderReq.mobileNumber}),'%') </if> "
            + " AND (uo.order_id IN(SELECT order_id FROM user_order WHERE receive_time &lt;= #{recieveIntervalTime} AND hand_situation ='待拨打' )"
            + " OR uo.order_id IN(SELECT order_id FROM user_order WHERE receive_time &lt;= #{notSuccessTime} AND hand_situation !='待拨打' AND hand_situation!='成功')"
            + " OR uo.order_id IN(SELECT order_id FROM user_order WHERE receive_time &lt;= #{successTime} AND hand_situation='成功')"
            + " OR uo.job_number IS NULL)  AND is_sensitive=1  </where>  ORDER BY uo.`create_time`,uo.receive_time</script>")
    public List<MobileOrderDto> recieveListOrder(
            @Param("receiveOrderReq") ReceiveOrderReq receiveOrderReq,
            @Param("recieveIntervalTime") String recieveIntervalTime,
            @Param("notSuccessTime") String notSuccessTime, @Param("successTime") String successTime);

    @Select("<script>SELECT DISTINCT mo.id AS tempId,mo.* FROM mobile_order mo LEFT JOIN user_order uo ON mo.id=uo.order_id "
            + "<where>"
            + "<if test='receiveOrderReq.areaId != null'> "
            + " AND mo.area_id=#{receiveOrderReq.areaId} </if>"
            + "<if test='receiveOrderReq.mainMeal != null'>"
            + "   AND mo.main_meal like #{receiveOrderReq.mainMeal} </if>"
            + "<if test='receiveOrderReq.secondMeal != null'>"
            + "   AND mo.second_meal like #{receiveOrderReq.secondMeal} </if>"
            + "<if test='receiveOrderReq.broadband == 1'>"
            + "   AND mo.broadband !='' </if>"
            + "<if test='receiveOrderReq.broadband == 2'>"
            + "   AND mo.broadband ='' </if>"
            + "<if test='receiveOrderReq.mobileNumber != null'>"
            + "   AND mobile_number like concat(concat('%',#{receiveOrderReq.mobileNumber}),'%') </if> "
            + " </where>  ORDER BY uo.`create_time`,uo.receive_time</script>")
    public List<MobileOrderDto> recieveListOrderAdmin(
            @Param("receiveOrderReq") ReceiveOrderReq receiveOrderReq);

    @Select("SELECT DISTINCT main_meal FROM mobile_order")
    public List<String> getListMainMeal();

    @Select("SELECT DISTINCT second_meal FROM mobile_order")
    public List<String> getListSecondMeal();

    @Select("<script>SELECT area_id,mobile_number,main_meal,second_meal,broadband,is_sensitive,user_id,order_id,"
            + "order_state,hand_situation,receive_time,remarks,job_number,user_name,dev_id,mobile_job_number,main_course,"
            + "pair_course,broadband_info,newly_open,price_difference,dep_name FROM mobile_order mo JOIN user_order uo ON mo.`id`=uo.`order_id` "
            + " JOIN department d ON d.id =uo.dev_id<where> "
            + "<if test='queryReq.jobNumber != null'>  AND job_number=#{queryReq.jobNumber}</if>"
            + "<if test='queryReq.startTime != null'> AND receive_time &gt;= #{queryReq.startTime}</if>"
            + "<if test='queryReq.endTime != null'> AND receive_time &lt; #{queryReq.endTime}</if>"
            + "<if test='queryReq.mobileJobNumber != null'> AND mobile_job_number =#{queryReq.mobileJobNumber}</if>"
            + "<if test='queryReq.departmentId != null'> AND dev_id =#{queryReq.departmentId}</if>"
            + " </where> ORDER BY uo.receive_time </script>")
    public List<UserOrderQueryInfo> listOrderByCount(@Param("queryReq") CountReq queryReq);

    @Insert("<script>INSERT INTO mobile_order (area_id,mobile_number,main_meal,second_meal,broadband,is_sensitive,backup_field_one,backup_field_two)"
            + "VALUES <foreach collection ='list' item='order' separator =','>"
            + "(#{order.areaId},#{order.mobileNumber}, #{order.mainMeal}, #{order.secondMeal}, #{order.broadband}, #{order.isSensitive}, "
            + "#{order.backupFieldOne}, #{order.backupFieldTwo})</foreach >"
            + "ON DUPLICATE KEY UPDATE main_meal=VALUES(main_meal),second_meal=VALUES(second_meal),broadband=VALUES(broadband),"
            + "is_sensitive=VALUES(is_sensitive),backup_field_one=VALUES(backup_field_one),backup_field_two=VALUES(backup_field_two)"
            + "</script>")
    public int insertListOnUpdate(List<MobileOrder> orders);
}

package com.resource.distribute.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author huangwenjun
 * @version 2018年5月29日 下午10:41:14
 */
public class UserOrder {
    private Integer id;
    private Integer userId;
    private Integer orderId;
    private String orderState;
    private String handSituation;
    private String remarks;
    private String jobNumber;
    private String userName;
    private Integer devId;
    private String mobileJobNumber;
    private Date receiveTime;
    private Integer createBy;
    private Integer updateBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String mainCourse; // 主套餐
    private String pairCourse; // 副套餐
    private String broadbandInfo; // 宽带
    private String newlyOpen; // 新开
    private Integer priceDifference; // 价差

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getHandSituation() {
        return handSituation;
    }

    public void setHandSituation(String handSituation) {
        this.handSituation = handSituation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileJobNumber() {
        return mobileJobNumber;
    }

    public void setMobileJobNumber(String mobileJobNumber) {
        this.mobileJobNumber = mobileJobNumber;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getPairCourse() {
        return pairCourse;
    }

    public void setPairCourse(String pairCourse) {
        this.pairCourse = pairCourse;
    }

    public String getBroadbandInfo() {
        return broadbandInfo;
    }

    public void setBroadbandInfo(String broadbandInfo) {
        this.broadbandInfo = broadbandInfo;
    }

    public String getNewlyOpen() {
        return newlyOpen;
    }

    public void setNewlyOpen(String newlyOpen) {
        this.newlyOpen = newlyOpen;
    }

    public Integer getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(Integer priceDifference) {
        this.priceDifference = priceDifference;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

}

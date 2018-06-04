package com.resource.distribute.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author huangwenjun
 * @Date 2018年5月30日
 */
public class UserOrderQueryInfo {
    private Integer areaId;// 关联的区域id
    private String areaName;
    private String mobileNumber;// 手机号
    private String mainMeal;// 主套餐
    private String secondMeal;// 副套餐
    private String broadband;// 宽带情况
    private Integer isSensitive;// 是否为敏感 1->普通 2->敏感
    private Integer userId;// 用户id
    private Integer orderId;// 单子id
    private String orderState;// 状态
    private String handSituation;// 办理情况
    private String remarks;// 备注
    private String jobNumber;// 工号
    private String userName;// 姓名
    private String mobileJobNumber;// 移动工号
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receiveTime;// 接收时间
    private String mainCourse; // 主套餐
    private String pairCourse; // 副套餐
    private String broadbandInfo; // 宽带
    private String newlyOpen; // 新开
    private Integer priceDifference; // 价差
    private Integer devId;// 部门id

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMainMeal() {
        return mainMeal;
    }

    public void setMainMeal(String mainMeal) {
        this.mainMeal = mainMeal;
    }

    public String getSecondMeal() {
        return secondMeal;
    }

    public void setSecondMeal(String secondMeal) {
        this.secondMeal = secondMeal;
    }

    public String getBroadband() {
        return broadband;
    }

    public void setBroadband(String broadband) {
        this.broadband = broadband;
    }

    public Integer getIsSensitive() {
        return isSensitive;
    }

    public void setIsSensitive(Integer isSensitive) {
        this.isSensitive = isSensitive;
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

    @Override
    public String toString() {
        return "UserOrderQueryInfo [areaId=" + areaId + ", mobileNumber=" + mobileNumber
                + ", mainMeal=" + mainMeal + ", secondMeal=" + secondMeal + ", broadband="
                + broadband + ", isSensitive=" + isSensitive + ", userId=" + userId + ", orderId="
                + orderId + ", orderState=" + orderState + ", handSituation=" + handSituation
                + ", remarks=" + remarks + ", jobNumber=" + jobNumber + ", userName=" + userName
                + ", mobileJobNumber=" + mobileJobNumber + ", receiveTime=" + receiveTime
                + ", mainCourse=" + mainCourse + ", pairCourse=" + pairCourse + ", broadbandInfo="
                + broadbandInfo + ", newlyOpen=" + newlyOpen + ", priceDifference="
                + priceDifference + "]";
    }
}

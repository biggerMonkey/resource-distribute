package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午11:02:09
 */
public class ReceiveOrderReq {
    private Integer areaId;
    private String mainMeal;
    private String secondMeal;
    private String upValue;
    private Integer broadband;// 1->是 2->否
    private String mobileNumber;
    private Integer orderNum;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public String getUpValue() {
        return upValue;
    }

    public void setUpValue(String upValue) {
        this.upValue = upValue;
    }

    public Integer getBroadband() {
        return broadband;
    }

    public void setBroadband(Integer broadband) {
        this.broadband = broadband;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "ReceiveOrderReq [areaId=" + areaId + ", mainMeal=" + mainMeal + ", secondMeal="
                + secondMeal + ", upValue=" + upValue + ", broadband=" + broadband
                + ", mobileNumber=" + mobileNumber + ", orderNum=" + orderNum + "]";
    }
}

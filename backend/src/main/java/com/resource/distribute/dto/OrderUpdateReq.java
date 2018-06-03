package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:45:58
 */
public class OrderUpdateReq {
    private Integer orderId;
    private String state;// 状态
    private String handSituation;// 办理情况
    private String remarks;

    private String mainCourse; //主套餐
    private String pairCourse; //副套餐
    private String broadband; //宽带
    private String newlyOpen; //新开
    private String priceDifference; //价差

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getBroadband() {
        return broadband;
    }

    public void setBroadband(String broadband) {
        this.broadband = broadband;
    }

    public String getNewlyOpen() {
        return newlyOpen;
    }

    public void setNewlyOpen(String newlyOpen) {
        this.newlyOpen = newlyOpen;
    }

    public String getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(String priceDifference) {
        this.priceDifference = priceDifference;
    }
}

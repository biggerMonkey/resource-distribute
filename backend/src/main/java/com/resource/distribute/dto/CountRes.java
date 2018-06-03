package com.resource.distribute.dto;

import java.util.List;

/**
 * @author huangwenjun
 * @Date 2018年6月1日
 */
public class CountRes {
    private int recieveNum;
    private int successNum;
    private double successRate;
    private int totalPriceDiff;
    private List<UserOrderQueryInfo> userOrderQueryInfos;

    public int getRecieveNum() {
        return recieveNum;
    }

    public void setRecieveNum(int recieveNum) {
        this.recieveNum = recieveNum;
    }

    public int getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public int getTotalPriceDiff() {
        return totalPriceDiff;
    }

    public void setTotalPriceDiff(int totalPriceDiff) {
        this.totalPriceDiff = totalPriceDiff;
    }

    public List<UserOrderQueryInfo> getUserOrderQueryInfos() {
        return userOrderQueryInfos;
    }

    public void setUserOrderQueryInfos(List<UserOrderQueryInfo> userOrderQueryInfos) {
        this.userOrderQueryInfos = userOrderQueryInfos;
    }
}

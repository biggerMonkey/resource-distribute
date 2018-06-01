package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @Date 2018年6月1日
 */
public class CountRes {
    private int recieveNum;
    private int successNum;
    private double successRate;

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
}

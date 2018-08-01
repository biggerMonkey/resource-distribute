package com.resource.distribute.entity;

import java.util.Date;

import javax.persistence.Id;

/**
 * @author huangwenjun
 * @version 2018年7月28日 上午11:51:49
 */
public class OrderRecieveRecord {
    @Id
    private Integer id;
    private Integer orderId;
    private String handSituation;
    private Date receiveTime;
    private String mainMeal;
    private String secondMeal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getHandSituation() {
        return handSituation;
    }

    public void setHandSituation(String handSituation) {
        this.handSituation = handSituation;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
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
}

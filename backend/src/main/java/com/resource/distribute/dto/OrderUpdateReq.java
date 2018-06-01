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
}

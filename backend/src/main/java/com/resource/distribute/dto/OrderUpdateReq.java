package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:45:58
 */
public class OrderUpdateReq {
    private Integer id;
    private String state;// 状态
    private String handSituation;// 办理情况
    private String remarks;// 备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "OrderReq [id=" + id + ", state=" + state + ", handSituation=" + handSituation
                + ", remarks=" + remarks + "]";
    }
}

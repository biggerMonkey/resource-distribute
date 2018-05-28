package com.resource.distribute.dto;

import com.resource.distribute.common.Constant;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:48:33
 */
public class OrderQueryReq {
    private Integer areaId;
    private String handSituation;
    private String startTime;
    private String endTime;
    private int pageSize = Constant.PAGE.DEFAULT_PAGE_SIZE;
    private int pageNo = Constant.PAGE.DEFAULT_PAGE_NUM;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getHandSituation() {
        return handSituation;
    }

    public void setHandSituation(String handSituation) {
        this.handSituation = handSituation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

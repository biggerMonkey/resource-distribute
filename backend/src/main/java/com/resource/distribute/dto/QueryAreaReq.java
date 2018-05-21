package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class QueryAreaReq {
    private String areaName;
    private int pageSize = 20;
    private int pageNum = 1;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}

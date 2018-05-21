package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class QueryMobileReq {
    private String mobileJobNumber;
    private int pageSize = 20;
    private int pageNum = 1;


    public String getMobileJobNumber() {
        return mobileJobNumber;
    }

    public void setMobileJobNumber(String mobileJobNumber) {
        this.mobileJobNumber = mobileJobNumber;
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

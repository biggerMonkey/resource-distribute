package com.resource.distribute.dto;

import com.resource.distribute.common.Constant;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class QueryMobileReq {
    private String mobileJobNumber = "";
    private int pageSize = Constant.PAGE.DEFAULT_PAGE_SIZE;
    private int pageNo = Constant.PAGE.DEFAULT_PAGE_NUM;


    public String getMobileJobNumber() {
        return mobileJobNumber;
    }

    public void setMobileJobNumber(String mobileJobNumber) {
        this.mobileJobNumber = mobileJobNumber;
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

package com.resource.distribute.dto;

import com.resource.distribute.common.Constant;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class QueryUserReq {
    private String jobNumber = "";
    private String userName = "";
    private int pageSize = Constant.PAGE.DEFAULT_PAGE_SIZE;
    private int pageNo = Constant.PAGE.DEFAULT_PAGE_NUM;

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

}

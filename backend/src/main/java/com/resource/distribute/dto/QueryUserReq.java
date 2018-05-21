package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class QueryUserReq {
    private String jobNumber;
    private String userName;
    private int pageSize = 20;
    private int pageNum = 1;

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "QueryUserReq [jobNumber=" + jobNumber + ", userName=" + userName + ", pageSize="
                + pageSize + ", pageNum=" + pageNum + "]";
    }
}

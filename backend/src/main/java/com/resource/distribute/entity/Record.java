package com.resource.distribute.entity;

import java.util.Date;

/**
 * @author huangwenjun
 * @version 2018年5月22日 下午10:57:23
 */
public class Record {
    private Integer id;
    private String jobNum;
    private String userName;
    private String mobileJobNum;
    private String content;
    private Integer orderId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileJobNum() {
        return mobileJobNum;
    }

    public void setMobileJobNum(String mobileJobNum) {
        this.mobileJobNum = mobileJobNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Record [id=" + id + ", jobNum=" + jobNum + ", userName=" + userName
                + ", mobileJobNum=" + mobileJobNum + ", content=" + content + ", orderId=" + orderId
                + ", createTime=" + createTime + "]";
    }
}

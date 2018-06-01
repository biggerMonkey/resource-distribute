package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @Date 2018年6月1日
 */
public class CountReq {
    private String startTime;
    private String endTime;
    private String jobNumber;
    private String mobileJobNumber;

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

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getMobileJobNumber() {
        return mobileJobNumber;
    }

    public void setMobileJobNumber(String mobileJobNumber) {
        this.mobileJobNumber = mobileJobNumber;
    }
}

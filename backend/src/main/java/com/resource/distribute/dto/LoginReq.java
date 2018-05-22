package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @Date 2018年5月22日
 */
public class LoginReq {
    private String jobNumber;
    private String password;

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq [jobNumber=" + jobNumber + ", password=" + password + "]";
    }
}

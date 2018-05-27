package com.resource.distribute.dto;

/**
 * @author huangwenjun
 * @version 2018年5月26日 下午5:02:06
 */
public class SysConfigReq {
    private int id;
    private String sysValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

    @Override
    public String toString() {
        return "SysConfigReq [id=" + id + ", sysValue=" + sysValue + "]";
    }
}

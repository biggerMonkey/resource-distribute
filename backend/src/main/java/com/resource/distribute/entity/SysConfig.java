package com.resource.distribute.entity;

import java.util.Date;

import javax.persistence.Id;

/**
 * @author huangwenjun
 * @version 2018年5月26日 下午5:02:06
 */
public class SysConfig {
    @Id
    private Integer id;
    private String sysKey;
    private String sysValue;
    private Date createTime;
    private Date updateTime;
    private Integer updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "SysConfig [id=" + id + ", sysKey=" + sysKey + ", sysValue=" + sysValue
                + ", createTime=" + createTime + ", updateTime=" + updateTime + ", updateBy="
                + updateBy + "]";
    }
}

package com.resource.distribute.entity;

import java.util.Date;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class MobileJobNumber {
    @Id
    private Integer id;
    @NotEmpty
    private String mobileJobNumber;
    private Date createTime;
    private Date updateTime;
    private Integer createBy;
    private Integer updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getMobileJobNumber() {
        return mobileJobNumber;
    }

    public void setMobileJobNumber(String mobileJobNumber) {
        this.mobileJobNumber = mobileJobNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "MobileJobNumber [id=" + id + ", mobileJobNumber=" + mobileJobNumber
                + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createBy="
                + createBy + ", updateBy=" + updateBy + "]";
    }
}

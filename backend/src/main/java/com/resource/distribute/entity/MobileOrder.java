package com.resource.distribute.entity;

import java.util.Date;

import javax.persistence.Id;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:33:35
 */
public class MobileOrder {
    @Id
    private Integer id;
    private Integer areaId;// 关联的区域id
    private String mobileNumber;// 手机号
    private String mainMeal;// 主套餐
    private String secondMeal;// 副套餐
    private String broadband;// 宽带情况
    private Integer isSensitive;// 是否为敏感 1->普通 2->敏感
    private String backupFieldOne;
    private String backupFieldTwo;
    private Integer createBy;
    private Integer updateBy;// 更新人
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMainMeal() {
        return mainMeal;
    }

    public void setMainMeal(String mainMeal) {
        this.mainMeal = mainMeal;
    }

    public String getSecondMeal() {
        return secondMeal;
    }

    public void setSecondMeal(String secondMeal) {
        this.secondMeal = secondMeal;
    }

    public String getBroadband() {
        return broadband;
    }

    public void setBroadband(String broadband) {
        this.broadband = broadband;
    }

    public Integer getIsSensitive() {
        return isSensitive;
    }

    public void setIsSensitive(Integer isSensitive) {
        this.isSensitive = isSensitive;
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

    public String getBackupFieldOne() {
        return backupFieldOne;
    }

    public void setBackupFieldOne(String backupFieldOne) {
        this.backupFieldOne = backupFieldOne;
    }

    public String getBackupFieldTwo() {
        return backupFieldTwo;
    }

    public void setBackupFieldTwo(String backupFieldTwo) {
        this.backupFieldTwo = backupFieldTwo;
    }
}

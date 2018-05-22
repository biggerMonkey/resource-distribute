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
    private String upValue;// up值
    private String overFlow;// 溢出流程(M)
    private String broadband;// 宽带情况
    private String state;// 状态
    private String handSituation;// 办理情况
    private String remarks;// 备注
    private String jobNumber;// 工号
    private String userName;// 姓名
    private String mobileJobNumber;// 移动工号
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

    public String getUpValue() {
        return upValue;
    }

    public void setUpValue(String upValue) {
        this.upValue = upValue;
    }

    public String getOverFlow() {
        return overFlow;
    }

    public void setOverFlow(String overFlow) {
        this.overFlow = overFlow;
    }

    public String getBroadband() {
        return broadband;
    }

    public void setBroadband(String broadband) {
        this.broadband = broadband;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHandSituation() {
        return handSituation;
    }

    public void setHandSituation(String handSituation) {
        this.handSituation = handSituation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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

    public String getMobileJobNumber() {
        return mobileJobNumber;
    }

    public void setMobileJobNumber(String mobileJobNumber) {
        this.mobileJobNumber = mobileJobNumber;
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

    @Override
    public String toString() {
        return "MobileOrder [id=" + id + ", areaId=" + areaId + ", mobileNumber=" + mobileNumber
                + ", mainMeal=" + mainMeal + ", secondMeal=" + secondMeal + ", upValue=" + upValue
                + ", overFlow=" + overFlow + ", broadband=" + broadband + ", state=" + state
                + ", handSituation=" + handSituation + ", remarks=" + remarks + ", jobNumber="
                + jobNumber + ", userName=" + userName + ", mobileJobNumber=" + mobileJobNumber
                + ", createBy=" + createBy + ", updateBy=" + updateBy + ", createTime=" + createTime
                + ", updateTime=" + updateTime + "]";
    }

}

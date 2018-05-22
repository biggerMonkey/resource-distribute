package com.resource.distribute.entity;

import java.util.Date;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class User {
    @Id
    private Integer id;
    private String jobNumber;// 工号
    @NotEmpty
    private String userName;// 姓名
    @NotEmpty
    private String password;// 密码
    private Integer isEnable;
    private Integer isDelete;
    private Integer roleType;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
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
        return "User [id=" + id + ", jobNumber=" + jobNumber + ", userName=" + userName
                + ", password=" + password + ", isDelete=" + isDelete + ", roleType=" + roleType
                + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createBy="
                + createBy + ", updateBy=" + updateBy + "]";
    }
}

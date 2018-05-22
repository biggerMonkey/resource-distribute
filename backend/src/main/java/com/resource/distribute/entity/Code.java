package com.resource.distribute.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public class Code {
    @Id
    private Integer id;
    @NotEmpty
    private String content;
    @NotNull
    private Integer parentId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
        return "Code [id=" + id + ", content=" + content + ", parentId=" + parentId
                + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createBy="
                + createBy + ", updateBy=" + updateBy + "]";
    }
}

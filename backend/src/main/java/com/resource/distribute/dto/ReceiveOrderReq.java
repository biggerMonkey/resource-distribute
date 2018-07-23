package com.resource.distribute.dto;

import com.resource.distribute.common.Constant;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午11:02:09
 */
public class ReceiveOrderReq {
    private Integer areaId;
    private String mainMeal;// 主套餐
    private String secondMeal;// 副套餐
    private Integer broadband;// 1->是 2->否
    private String mobileNumber;// 手机号
    private Integer orderNum;// 领取单子数量
    private String[] mainMealSelect;
    private int pageSize = Constant.PAGE.DEFAULT_PAGE_SIZE;
    private int pageNo = Constant.PAGE.DEFAULT_PAGE_NUM;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getBroadband() {
        return broadband;
    }

    public void setBroadband(Integer broadband) {
        this.broadband = broadband;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String[] getMainMealSelect() {
        return mainMealSelect;
    }

    public void setMainMealSelect(String[] mainMealSelect) {
        this.mainMealSelect = mainMealSelect;
    }
}

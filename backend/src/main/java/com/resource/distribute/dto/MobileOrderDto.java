package com.resource.distribute.dto;

import com.resource.distribute.entity.MobileOrder;

/**
 * @author huangwenjun
 * @Date 2018年6月4日
 */
public class MobileOrderDto extends MobileOrder {
    private String areaName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}

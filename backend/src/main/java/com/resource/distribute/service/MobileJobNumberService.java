package com.resource.distribute.service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.QueryMobileReq;
import com.resource.distribute.entity.MobileJobNumber;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface MobileJobNumberService {

    public ReturnInfo addMobile(MobileJobNumber mobileJobNumber);

    public ReturnInfo updateMobile(MobileJobNumber mobileJobNumber);

    public ReturnInfo delMobileById(Integer mobileJobNumberId);

    public ReturnInfo listMobile(QueryMobileReq queryMobileReq);
}

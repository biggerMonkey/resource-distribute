package com.resource.distribute.service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.SysConfigReq;

/**
 * @author huangwenjun
 * @version 2018年5月26日 下午5:03:29
 */
public interface SysConfigService {
    public ReturnInfo updateConfig(SysConfigReq configReq);

    public ReturnInfo getList();

    public ReturnInfo getListById(Integer id);

}

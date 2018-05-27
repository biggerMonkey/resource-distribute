package com.resource.distribute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.SysConfigDao;
import com.resource.distribute.dto.SysConfigReq;
import com.resource.distribute.entity.SysConfig;
import com.resource.distribute.service.SysConfigService;
import com.resource.distribute.utils.AuthCurrentUser;

/**
 * @author huangwenjun
 * @version 2018年5月26日 下午5:05:46
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public ReturnInfo updateConfig(SysConfigReq configReq) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setId(configReq.getId());
        sysConfig.setSysValue(configReq.getSysValue());
        sysConfig.setUpdateBy(AuthCurrentUser.getUserId());
        sysConfigDao.updateByPrimaryKeySelective(sysConfig);
        return ReturnInfo.createReturnSuccessOne(null);
    }

}

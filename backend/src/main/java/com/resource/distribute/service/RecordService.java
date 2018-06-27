package com.resource.distribute.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.RecordQueryReq;

/**
 * @author huangwenjun
 * @Date 2018年6月27日
 */
public interface RecordService {
    public ReturnInfo logList(@RequestBody RecordQueryReq logQueryReq);
}

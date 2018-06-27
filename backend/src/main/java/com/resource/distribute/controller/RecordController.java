package com.resource.distribute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.RecordQueryReq;
import com.resource.distribute.service.RecordService;

/**
 * @author huangwenjun
 * @Date 2018年6月27日
 */
@RestController
@RequestMapping("/resource/record")
public class RecordController {

    @Autowired
    private RecordService logService;

    @PostMapping("/query")
    public ReturnInfo logList(@RequestBody RecordQueryReq logQueryReq) {
        return logService.logList(logQueryReq);
    }
}

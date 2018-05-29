package com.resource.distribute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.SysConfigReq;
import com.resource.distribute.service.SysConfigService;

/**
 * @author huangwenjun
 * @version 2018年5月26日 下午5:08:17
 */
@RestController
@RequestMapping("/resource/config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping("/update")
    public ReturnInfo update(@RequestBody SysConfigReq sysConfigReq) {

        return sysConfigService.updateConfig(sysConfigReq);
    }

    @RequestMapping("/all")
    public ReturnInfo getAll() {
        return sysConfigService.getList();
    }

    @GetMapping("/query/{id}")
    public ReturnInfo getListById(@PathVariable("id") Integer id) {
        return sysConfigService.getListById(id);
    }
}

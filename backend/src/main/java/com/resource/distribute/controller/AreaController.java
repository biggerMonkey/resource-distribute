package com.resource.distribute.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.QueryAreaReq;
import com.resource.distribute.entity.Area;
import com.resource.distribute.service.AreaService;
import com.resource.distribute.utils.ValidateLogUtils;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@RestController
@RequestMapping("/resource/area")
public class AreaController {
    private static Logger LOG = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;

    @PostMapping("/add")
    public ReturnInfo addArea(@RequestBody @Valid Area area, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return areaService.addArea(area);
    }

    @PostMapping("/update")
    public ReturnInfo updateArea(@RequestBody @Valid Area area, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return areaService.updateArea(area);
    }

    @GetMapping("/del/{area-id}")
    public ReturnInfo delAreaById(@PathVariable("area-id") Integer areaId) {
        return areaService.delAreaById(areaId);
    }

    @PostMapping("/query")
    public ReturnInfo listArea(@RequestBody @Valid QueryAreaReq queryAreaReq) {
        return areaService.listArea(queryAreaReq);
    }
}

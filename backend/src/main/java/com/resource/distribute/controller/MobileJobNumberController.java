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
import com.resource.distribute.dto.QueryMobileReq;
import com.resource.distribute.entity.MobileJobNumber;
import com.resource.distribute.service.MobileJobNumberService;
import com.resource.distribute.utils.ValidateLogUtils;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@RestController
@RequestMapping("/resource/mobile")
public class MobileJobNumberController {
    private static Logger LOG = LoggerFactory.getLogger(MobileJobNumberController.class);
    @Autowired
    private MobileJobNumberService mobileJobNumberService;

    @PostMapping("/add")
    public ReturnInfo addArea(@RequestBody @Valid MobileJobNumber mobileJobNumber,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return mobileJobNumberService.addMobile(mobileJobNumber);
    }

    @PostMapping("/update")
    public ReturnInfo updateArea(@RequestBody @Valid MobileJobNumber mobileJobNumber,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return mobileJobNumberService.updateMobile(mobileJobNumber);
    }

    @GetMapping("/del/{mobile-id}")
    public ReturnInfo delAreaById(@PathVariable("mobile-id") Integer mobileJobNumberId) {
        return mobileJobNumberService.delMobileById(mobileJobNumberId);
    }

    @PostMapping("/query")
    public ReturnInfo listArea(@RequestBody @Valid QueryMobileReq queryMobileReq) {
        return mobileJobNumberService.listMobile(queryMobileReq);
    }
}

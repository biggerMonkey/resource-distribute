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

import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.entity.Code;
import com.resource.distribute.service.CodeService;
import com.resource.distribute.utils.ValidateLogUtils;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@RestController
@RequestMapping("/resource/code")
public class CodeController {

    private static Logger LOG = LoggerFactory.getLogger(CodeController.class);

    @Autowired
    private CodeService codeService;

    @PostMapping("/add")
    public ReturnInfo addCode(@RequestBody @Valid Code code, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        if (code.getParentId() == 0) {
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        return codeService.addCode(code);
    }

    @PostMapping("/update")
    public ReturnInfo updateCode(@RequestBody @Valid Code code, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidateLogUtils.paramError(bindingResult, LOG);
        }
        return codeService.updateCode(code);
    }

    @GetMapping("/del/{code-id}")
    public ReturnInfo delCodeById(@PathVariable("code-id") Integer codeId) {
        return codeService.delCodeById(codeId);
    }

    @GetMapping("/query/{parent-id}")
    public ReturnInfo listById(@PathVariable("parent-id") Integer parentId) {
        return codeService.listById(parentId);
    }
}

package com.resource.distribute.controller;


import com.alibaba.fastjson.JSON;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.entity.Department;
import com.resource.distribute.service.DepartmentService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "DepartmentController", description = "部门管理")
@RestController
@RequestMapping(path = "/resource/depart")
public class DepartmentController {


    private static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ReturnInfo addDepartment(@RequestBody Department department){
        LOG.info("部门添加数据为:{}",JSON.toJSONString(department));
        return departmentService.add(department);
    }

    @GetMapping("/list/{pageNum}")
    public ReturnInfo listDepartment(@PathVariable("pageNum")Integer pageNum,@RequestParam("search")String depName){
        if (depName != null && depName.length() == 0){
            depName = null;
        }
        return departmentService.list(pageNum, depName);
    }

    @DeleteMapping(path = "/del/{id}")
    public ReturnInfo delDepart(@PathVariable("id")Integer id){
        if (id == 0 || id < 0){
            LOG.info("id:{}",id);
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        return departmentService.del(id);
    }

    @PutMapping(path = "/update")
    public ReturnInfo update(@RequestBody Department department){
        Integer id = department.getId();
        if (id == null || id == 0 || id < 0){
            LOG.info("id:{}",id);
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        return departmentService.update(department);
    }


    @GetMapping(path = "/find/{id}")
    public ReturnInfo find(@PathVariable("id")Integer id){
        if (id == 0 || id < 0){
            LOG.info("id:{}",id);
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        return departmentService.find(id);
    }

    @GetMapping(path = "/all")
    public ReturnInfo all(){
        return departmentService.all();
    }
}

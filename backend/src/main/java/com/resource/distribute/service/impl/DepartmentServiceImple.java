package com.resource.distribute.service.impl;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.DepartmentDao;
import com.resource.distribute.entity.Department;
import com.resource.distribute.service.DepartmentService;
import com.resource.distribute.utils.AuthCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImple implements DepartmentService {


    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public ReturnInfo add(Department department) {
        department.setCreateBy(AuthCurrentUser.getUserId());
        departmentDao.insertSelective(department);
        return ReturnInfo.create(CodeEnum.SUCCESS);
    }

    @Override
    public ReturnInfo list(Integer pageNum, String depName) {
        PageHelper.startPage(pageNum,10);
        List<Department> departments = departmentDao.selectDepartment(depName);
        return ReturnInfo.createReturnSucces(departments);
    }

    @Override
    public ReturnInfo del(Integer id) {
        Department department = new Department();
        department.setId(id);
        department.setUpdateBy(AuthCurrentUser.getUserId());
        department.setIsDelete(Constant.DEPARTMENT.IS_DELETE);
        departmentDao.updateByPrimaryKeySelective(department);
        return ReturnInfo.create(CodeEnum.SUCCESS);
    }

    @Override
    public ReturnInfo update(Department department) {
        department.setUpdateBy(AuthCurrentUser.getUserId());
        departmentDao.updateByPrimaryKeySelective(department);
        return ReturnInfo.create(CodeEnum.SUCCESS);
    }

    @Override
    public ReturnInfo find(Integer id) {
        Department department = departmentDao.selectById(id);
        return ReturnInfo.createReturnSuccessOne(department);
    }

    @Override
    public ReturnInfo all() {
        List<Department> departments = departmentDao.selectAll();
        return ReturnInfo.createReturnSuccessOne(departments);
    }

}

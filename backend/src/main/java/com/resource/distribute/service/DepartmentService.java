package com.resource.distribute.service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.entity.Department;

public interface DepartmentService {

    public ReturnInfo add(Department department);

    public ReturnInfo list(Integer pageNum,String depName);

    public ReturnInfo del(Integer id);

    public ReturnInfo update(Department department);

    public ReturnInfo find(Integer id);

    public ReturnInfo all();
}

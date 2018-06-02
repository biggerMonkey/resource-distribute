package com.resource.distribute.dao;

import com.resource.distribute.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DepartmentDao extends Mapper<Department> {

    @Select({"<select>" +
            "select * from department" +
            "<where>" +
            "<if test=\" depName != null \">" +
            "dep_name like concat('%',concat(#{depName},'%'))" +
            "</if>" +
            "and is_delete=2" +
            "</where>" +
            "</select>"})
    List<Department> selectDepartment(@Param("depName")String depName);



    @Select("select * from department where id=#{id}")
    Department selectById(@Param("id")Integer id);

}

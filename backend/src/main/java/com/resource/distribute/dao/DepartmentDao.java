package com.resource.distribute.dao;

import com.resource.distribute.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DepartmentDao extends Mapper<Department> {

    @Select({"<script>" +
            "select * from department" +
            "<where>" +
            "<if test=\" depName != null \">" +
            " dep_name like concat('%',concat(#{depName},'%'))" +
            "</if>" +
            "and is_delete=2" +
            "</where>" +
            "</script>"})
    List<Department> selectDepartment(@Param("depName")String depName);



    @Select("select * from department where id=#{id} and is_delete=2")
    Department selectById(@Param("id")Integer id);



    @Select({"select * from department where is_delete=2"})
    List<Department> selectByNoDel();

}

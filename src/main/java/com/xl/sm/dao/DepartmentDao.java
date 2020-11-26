package com.xl.sm.dao;


import com.xl.sm.entity.Admin;
import com.xl.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description 院系DAO接口
 * @Author 1
 * @Date 2020/11/17
 **/
public interface DepartmentDao {
    /**
     *  查询所有院系
     *
     * @return  List<Department>
     * @throws SQLException  该方法会抛出SQL 异常
     */
    List<Department> getAll() throws SQLException;


    /**
     *  新增院系
     *
     * @param department 入参
     * @return  int
     * @throws SQLException  该方法会抛出SQL 异常
     */
    int insertDepartment(Department department) throws  SQLException;
}

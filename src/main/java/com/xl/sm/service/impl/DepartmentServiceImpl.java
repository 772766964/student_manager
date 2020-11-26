package com.xl.sm.service.impl;

import com.xl.sm.dao.DepartmentDao;
import com.xl.sm.entity.Department;
import com.xl.sm.factory.DaoFactory;
import com.xl.sm.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentServiceImpl
 * @Description TODO
 * @Author 1
 * @Date 2020/11/24
 **/
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    /**
     * 查询所有院系
     *
     * @return List<Department>
     */
    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try{
            departmentList = departmentDao.getAll();
        }catch (SQLException e){
            System.err.println("查询院系信息出现异常");
        }
        return departmentList;
    }
}

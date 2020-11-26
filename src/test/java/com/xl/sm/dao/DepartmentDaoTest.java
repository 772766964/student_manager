package com.xl.sm.dao;

import com.xl.sm.entity.Department;
import com.xl.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDaoTest {

    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance()   ;

    @Test
    public void getAll() {
        List<Department> departmentsList = null;
        try{
            departmentsList = departmentDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        assert departmentsList != null;
        departmentsList.forEach(System.out::println);
    }

    @Test
    public void insertDepartment() {
        int n = 0;
        Department department = Department.builder()
                .departmentName("测试院系")
                .logo("0.jpg")
                .build();
        try {
            n = departmentDao.insertDepartment(department);
        } catch (SQLException e) {
            System.out.println("出错！");
            //e.printStackTrace();
        }
        assertEquals(1,n);
    }
}
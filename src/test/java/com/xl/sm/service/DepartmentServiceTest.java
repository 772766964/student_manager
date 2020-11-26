package com.xl.sm.service;

import com.xl.sm.entity.Department;
import com.xl.sm.factory.ServiceFactotry;
import org.junit.Test;

import java.util.List;

public class DepartmentServiceTest {

    private final DepartmentService departmentService = ServiceFactotry.getDepartmentServiceInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(System.out::println);
    }
}
package com.xl.sm.factory;

import com.xl.sm.service.AdminServie;
import com.xl.sm.service.DepartmentService;
import com.xl.sm.service.impl.AdminServiceImpl;
import com.xl.sm.service.impl.DepartmentServiceImpl;

/**
 * @ClassName ServiceFacotry
 * @Description TODO
 * @Author 1
 * @Date 2020/11/18
 **/
public class ServiceFactotry {
    public static AdminServie getAdminServiceInstance(){
        return new AdminServiceImpl();
    }

    public static DepartmentService getDepartmentServiceInstance(){
        return new DepartmentServiceImpl();
    }
}

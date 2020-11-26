package com.xl.sm.factory;

import com.xl.sm.dao.AdminDao;
import com.xl.sm.dao.DepartmentDao;
import com.xl.sm.dao.impl.AdminDaoImpl;
import com.xl.sm.dao.impl.DepartmentDaoImpl;

/**
 * @ClassName DaoFactory
 * @Description 工厂类
 * @Author 1
 * @Date 2020/11/17
 **/
public class DaoFactory {
    /**
     * 获得AdminDao 实例
     */
    public static AdminDao getAdminDaoInstance() {
        return new AdminDaoImpl();
    }

    /**
     * 获得DepartmentDao 实例
     *
     * @return AdminDao实例
     */
    public static DepartmentDao getDepartmentDaoInstance(){
        return new DepartmentDaoImpl();
    }
}

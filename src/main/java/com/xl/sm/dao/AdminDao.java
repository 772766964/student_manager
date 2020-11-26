package com.xl.sm.dao;

import com.xl.sm.entity.Admin;

import java.sql.SQLException;

/**
 * @ClassName AdminDao
 * @Description 管理员接口
 * @Author 1
 * @Date 2020/11/17
 **/
public interface AdminDao {
    /**
     *  根据账号查找管理员
     *
     * @param account 账户入参
     * @return Admin  管理员信息
     * @throws SQLException  该方法会抛出SQL 异常
     */
    Admin findAdminByAccount(String account) throws SQLException;
}

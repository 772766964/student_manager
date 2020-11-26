package com.xl.sm.dao.impl;

import com.xl.sm.dao.AdminDao;
import com.xl.sm.entity.Admin;
import com.xl.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName AdminDaoImpl
 * @Description TODO
 * @Author 1
 * @Date 2020/11/17
 **/
public class AdminDaoImpl implements AdminDao {
    /**
     * 根据账号查找管理员
     *
     * @param account 账户入参
     * @return Admin  管理员信息
     * @throws SQLException 该方法会抛出SQL 异常
     */
    @Override
    public Admin findAdminByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_admin WHERE account = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,account);
        ResultSet rs = pstmt.executeQuery();
        Admin admin = null;
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String adminAccount = rs.getString("account");
            String password =rs.getString("password");
            String adminName = rs.getString("admin_name");
            admin = new Admin();
            admin.setId(id);
            admin.setAccount(adminAccount);
            admin.setPassword(password);
            admin.setAdminName(adminName);
        }
        rs.close();;
        pstmt.close();
        jdbcUtil.closeConnection();
        return admin;
    }
}

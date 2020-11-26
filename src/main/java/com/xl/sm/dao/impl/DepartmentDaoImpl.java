package com.xl.sm.dao.impl;


import com.xl.sm.dao.DepartmentDao;
import com.xl.sm.entity.Department;
import com.xl.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DepartmentDaoImpl
 * @Description TODO
 * @Author 1
 * @Date 2020/11/23
 **/
public class DepartmentDaoImpl implements DepartmentDao {


    /**
     * 新增院系
     *
     * @param department 入参
     * @return int
     * @throws SQLException 该方法会抛出SQL 异常
     */
    @Override
    public int insertDepartment(Department department) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_department (department_name,logo) VALUES (?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,department.getDepartmentName());
        pstmt.setString(2,department.getLogo());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public List<Department> getAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_department";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Department> departmentList = new ArrayList<>();
        while (rs.next()){
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDepartmentName(rs.getString("department_name"));;
            department.setLogo(rs.getString("logo"));;
            departmentList.add(department);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return departmentList;
    }
}

package com.xl.sm.service;

import com.xl.sm.factory.ServiceFactotry;
import com.xl.sm.utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServieTest {

    private final AdminServie adminServie = ServiceFactotry.getAdminServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminServie.adminLogin("taoranran1@qq.com","1111");
        assertEquals(2,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}
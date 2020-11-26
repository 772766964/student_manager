package com.xl.sm.service;

import com.xl.sm.utils.ResultEntity;

public interface AdminServie {
    /**
     *
     * @param account 账号
     * @param   password 密码
     * @return  ResultEntity 返回结果
     */
    ResultEntity adminLogin(String account, String password);
}

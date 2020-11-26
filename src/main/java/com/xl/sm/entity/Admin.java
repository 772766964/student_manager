package com.xl.sm.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author 1
 * @Date 2020/11/17
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String account;
    private String password;
    private String adminName;
}

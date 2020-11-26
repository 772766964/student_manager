package com.xl.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Department
 * @Description TODO
 * @Author 1
 * @Date 2020/11/23
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
    private String logo;
}
package com.xl.sm.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResultEntity
 * @Description 返回结果实体
 * @Author 1
 * @Date 2020/11/18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultEntity {
    private int code;
    private String message;
    private Object data;
}

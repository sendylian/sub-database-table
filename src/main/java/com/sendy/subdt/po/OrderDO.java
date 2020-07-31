package com.sendy.subdt.po;// OrderDO.java

import lombok.Data;

/**
 * 订单 DO
 */
@Data
public class OrderDO {

    /**
     * 订单编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Integer userId;

    // ... 省略 setting/getting 方法
}
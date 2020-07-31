package com.sendy.subdt.dao;// OrderMapper.java

import com.sendy.subdt.po.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);

    void insert(OrderDO order);

}
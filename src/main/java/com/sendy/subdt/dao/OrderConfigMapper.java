package com.sendy.subdt.dao;// OrderConfigMapper.java

import com.sendy.subdt.po.OrderConfigDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderConfigMapper {

    OrderConfigDO selectById(@Param("id") Integer id);

}
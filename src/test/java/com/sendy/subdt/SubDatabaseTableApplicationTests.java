package com.sendy.subdt;

import com.sendy.subdt.dao.OrderConfigMapper;
import com.sendy.subdt.dao.OrderMapper;
import com.sendy.subdt.po.OrderDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SubDatabaseTableApplication.class)
public class SubDatabaseTableApplicationTests {

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderDO> orders = orderMapper.selectListByUserId(2);
        System.out.println(orders.size());
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(1);
        orderMapper.insert(order);
    }
/*
    @Test
    public void testSelectById() {
        OrderConfigDO orderConfig = orderConfigMapper.selectById(1);
        System.out.println(orderConfig);
    }*/

}

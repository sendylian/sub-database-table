package com.sendy.subdt;

import com.sendy.subdt.dao.OrderConfigMapper;
import com.sendy.subdt.dao.OrderMapper;
import com.sendy.subdt.dao.OrderMapperRW;
import com.sendy.subdt.po.OrderDO;
import org.apache.shardingsphere.api.hint.HintManager;
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
    @Autowired
    private OrderMapperRW orderMapperRW;


    //分库分表测试
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


//读写分离测试
    @Test
    public void testSelectByIdRW() { // 测试从库的负载均衡
        for (int i = 0; i < 3; i++) {
            OrderDO order = orderMapperRW.selectById(11);
            System.out.println(order);
        }
    }

    @Test
    public void testSelectById2RW() { // 测试强制访问主库
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            OrderDO order = orderMapperRW.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsertRW() { // 插入
        OrderDO order = new OrderDO();
        order.setUserId(10);
        orderMapperRW.insert(order);
    }

}

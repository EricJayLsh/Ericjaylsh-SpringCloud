package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.dao.OrderDao;
import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Order;
import com.ericjaylsh.springcloud.service.AccountService;
import com.ericjaylsh.springcloud.service.OrderService;
import com.ericjaylsh.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname OrderServiceImpl
 * @Description
 * @Date 2020/9/7 19:30
 * @Created by EricJayLsh
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    // TODO 日志通过AOP实现

    @GlobalTransactional(name = "seata_tx_group", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {

        log.info("开始创建订单");
        orderDao.create(order);
        log.info("结束创建订单");

        log.info("开始减库存");
        CommonResult storageResult = storageService.decrease(order.productId, order.count);
        log.info("减库结果" + storageResult);
        log.info("结束减库存");

        log.info("开始扣款");
        CommonResult accountResult = accountService.decrease(order.userId, order.money);
        log.info("扣款结果" + accountResult);
        log.info("结束扣款");

        log.info("开始修改订单状态");
        orderDao.update(order.userId, 0);
        log.info("结束修改订单状态");

        log.info("订单创建完成！！！");
    }

    @Override
    public CommonResult selectAll() {
        return new CommonResult(200, "success", orderDao.selectAll());
    }

}

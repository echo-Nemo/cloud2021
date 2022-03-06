package com.echo.service.impl;

import com.echo.dao.OrderDao;
import com.echo.domain.Order;
import com.echo.service.AccountService;
import com.echo.service.OrderService;
import com.echo.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    /*
    分布式全局事务的处理，即使在使用feign调用的服务发生异常时，都可以进行回滚
     */
    @GlobalTransactional
    @Override
    public void create(Order order) {
        log.info("开始新增order");
        orderDao.create(order);
        log.info("新增order结束");

        log.info("开始减库存");
        storageService.storageDesc(order.getProductId(), order.getCount());
        log.info("减库存介绍");

        log.info("开始扣余额");
        accountService.accountDecrease(order.getUserId(), order.getMoney());
        log.info("扣余额结束");
        update(order.getUserId(), 0);
    }

    @Override
    public void update(Long userId, Integer status) {
        log.info("更新order开始");
        orderDao.update(userId, status);
        log.info("更新order结束");
    }
}

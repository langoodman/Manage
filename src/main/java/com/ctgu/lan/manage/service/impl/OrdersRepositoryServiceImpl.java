package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.OrdersRepository;
import com.ctgu.lan.manage.model.Orders;
import com.ctgu.lan.manage.service.OrdersRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 15:46
 * @ClassName OrdersRepositoryServiceImpl
 * @Version 1.0.0
 */
@Service
public class OrdersRepositoryServiceImpl implements OrdersRepositoryService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Long countOrders() {
        return ordersRepository.count();
    }

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public Orders updateOrdersInfo(Orders orders) {
        return ordersRepository.saveAndFlush(orders);
    }

    @Override
    public Orders addOrdersInfo(Orders orders) {
        return ordersRepository.saveAndFlush(orders);
    }

    @Override
    public Orders findOneById(Integer id) {
        return ordersRepository.findOneById(id);
    }

    @Override
    public void deleOrdersById(Integer id) {
        ordersRepository.deleteById(id);
    }


}

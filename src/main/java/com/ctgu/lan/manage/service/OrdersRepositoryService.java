package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 15:43
 * @ClassName OrdersRepositoryService
 * @Version 1.0.0
 */
public interface OrdersRepositoryService {
    Long countOrders();
    Page<Orders> findAll(Pageable pageable);
    Orders updateOrdersInfo(Orders orders);
    Orders addOrdersInfo(Orders orders);
    Orders findOneById(Integer id);
    Orders findOneByPharmacyName(String pharmacyName );
    void deleOrdersById(Integer id);
}

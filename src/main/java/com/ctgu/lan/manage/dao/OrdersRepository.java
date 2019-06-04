package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 15:42
 * @ClassName OrdersRepository
 * @Version 1.0.0
 */
public interface OrdersRepository extends JpaRepository<Orders , Integer> {
    Page<Orders> findAll(Pageable pageable);
    Orders findOneById(Integer id );
    void deleteById(Integer id);
}

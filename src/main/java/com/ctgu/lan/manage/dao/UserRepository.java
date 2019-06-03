package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-02 16:15
 * @ClassName UserRepository
 * @Version 1.0.0
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);
}

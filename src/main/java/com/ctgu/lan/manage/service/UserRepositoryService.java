package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-02 16:44
 * @ClassName UserRepositoryService
 * @Version 1.0.0
 */
public interface UserRepositoryService {
    Long countUser();
    Page<User> findAll(Pageable pageable);
}

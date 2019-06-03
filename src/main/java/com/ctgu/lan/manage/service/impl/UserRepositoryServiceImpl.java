package com.ctgu.lan.manage.service.impl;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-02 16:45
 * @ClassName UserRepositoryServiceImpl
 * @Version 1.0.0
 */

import com.ctgu.lan.manage.dao.UserRepository;
import com.ctgu.lan.manage.model.User;
import com.ctgu.lan.manage.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Long countUser() {
        return userRepository.count();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User updateUserInfo(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User addUserInfo(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public User findOneById(Integer id) {
        return userRepository.findOneById(id);
    }

    @Override
    public void deleUserById(Integer id) {
        userRepository.deleteById(id);
    }
}

package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.AdminRepository;
import com.ctgu.lan.manage.model.Admin;
import com.ctgu.lan.manage.service.AdminRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-26 17:14
 * @ClassName AdminRepositoryServiceImpl
 * @Version 1.0.0
 */
@Service
public class AdminRepositoryServiceImpl implements AdminRepositoryService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByPhoneNumberAndPassWord(String phoneNumber, String passWord) {
        return adminRepository.findByPhoneNumberAndPassWord(phoneNumber , passWord);
    }
}

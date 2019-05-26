package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.AdminMapper;
import com.ctgu.lan.manage.model.Admin;
import com.ctgu.lan.manage.service.AdminMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-25 19:11
 * @ClassName AdminMapperServiceImpl
 * @Version 1.0.0
 */
@Service("AdminMapperService")
public class AdminMapperServiceImpl implements AdminMapperService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByUsernameAndPass(String phoneNumber, String passWord) {
        return adminMapper.findAdminByUsernameAndPass(phoneNumber,passWord);
    }
}

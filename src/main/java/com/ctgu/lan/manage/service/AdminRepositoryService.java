package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.Admin;
import org.springframework.data.repository.query.Param;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-26 17:12
 * @ClassName AdminRepositoryService
 * @Version 1.0.0
 */
public interface AdminRepositoryService {
    Admin findByPhoneNumberAndPassWord(String phoneNumber , String passWord);
    Admin findByEmailAndPhoneNumber(String email , String phoneNumber);
    int modifyNowTimeById(String nowTime, Integer id);
    int modifyPassWordById(@Param("passWord") String passWord, @Param("id") Integer id);
}

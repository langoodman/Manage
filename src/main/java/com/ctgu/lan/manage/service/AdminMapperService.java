package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-25 19:10
 * @ClassName AdminMapperService
 * @Version 1.0.0
 */
public interface AdminMapperService {
    Admin findAdminByUsernameAndPass(@Param("phoneNumber")String phoneNumber , @Param("passWord")String passWord);
}

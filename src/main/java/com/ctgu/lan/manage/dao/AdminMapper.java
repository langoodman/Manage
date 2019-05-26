package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    Admin findAdminByUsernameAndPass(@Param("phoneNumber")String phoneNumber , @Param("passWord")String passWord);


    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}
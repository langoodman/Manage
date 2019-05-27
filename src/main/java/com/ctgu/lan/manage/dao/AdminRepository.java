package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin , String> {
    Admin findByPhoneNumberAndPassWord(String phoneNumber , String passWord);

}
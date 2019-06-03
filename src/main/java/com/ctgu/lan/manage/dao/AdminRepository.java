package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Admin;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminRepository extends JpaRepository<Admin , Integer> {
    Admin findByPhoneNumberAndPassWord(String phoneNumber , String passWord);
    Admin findByEmailAndPhoneNumber(String email , String phoneNumber);
    @Modifying
    @Query(nativeQuery = true,value = "update admin a set a.last_time = :nowTime where a.id = :id")
    int modifyNowTimeById(@Param("nowTime") String nowTime, @Param("id") Integer id);
    @Modifying
    @Query(nativeQuery = true,value = "update admin a set a.pass_word = :passWord where a.id = :id")
    int modifyPassWordById(@Param("passWord") String passWord, @Param("id") Integer id);

}
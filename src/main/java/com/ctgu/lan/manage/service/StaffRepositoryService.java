package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 13:16
 * @ClassName StaffRepositoryService
 * @Version 1.0.0
 */
public interface StaffRepositoryService {
    Long countStaff();
    Page<Staff> findAll(Pageable pageable);
    Staff updateStaffInfo(Staff staff);
    Staff addStaffInfo(Staff staff);
    Staff findByPhoneNumber(String phoneNumber);
    Staff findOneById(Integer id);
    void deleUserById(Integer id);
}

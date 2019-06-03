package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.StaffRepository;
import com.ctgu.lan.manage.model.Staff;
import com.ctgu.lan.manage.service.StaffRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 13:16
 * @ClassName StaffRepositoryServiceImpl
 * @Version 1.0.0
 */
@Service
public class StaffRepositoryServiceImpl implements StaffRepositoryService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Long countStaff() {
        return staffRepository.count();
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Staff updateStaffInfo(Staff staff) {
        return staffRepository.saveAndFlush(staff);
    }

    @Override
    public Staff addStaffInfo(Staff staff) {
        return staffRepository.saveAndFlush(staff);
    }

    @Override
    public Staff findByPhoneNumber(String phoneNumber) {
        return staffRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Staff findOneById(Integer id) {
        return staffRepository.findOneById(id);
    }

    @Override
    public void deleUserById(Integer id) {
        staffRepository.deleteById(id);
    }
}

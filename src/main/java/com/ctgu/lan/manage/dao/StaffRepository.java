package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 13:15
 * @ClassName StaffRepository
 * @Version 1.0.0
 */
@Transactional
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    Page<Staff> findAll(Pageable pageable);
    Staff findByPhoneNumber(String phoneNumber);
    Staff findOneById(Integer id );
    void deleteById(Integer id);
}

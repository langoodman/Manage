package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 21:11
 * @ClassName PharmacyRepository
 * @Version 1.0.0
 */
public interface PharmacyRepository extends JpaRepository<Pharmacy , Integer> {
    Page<Pharmacy> findAll(Pageable pageable);
    Pharmacy findByPhoneNumber(String phoneNumber);
    Pharmacy findByName(String name);
    Pharmacy findOneById(Integer id );
    void deleteById(Integer id);
}

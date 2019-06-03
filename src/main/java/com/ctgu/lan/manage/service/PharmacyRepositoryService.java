package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 21:12
 * @ClassName PharmacyRepositoryService
 * @Version 1.0.0
 */
public interface PharmacyRepositoryService {
    Long countPharmacy();
    Page<Pharmacy> findAll(Pageable pageable);
    Pharmacy updatePharmacyInfo(Pharmacy pharmacy);
    Pharmacy addPharmacyInfo(Pharmacy pharmacy);
    Pharmacy findByPhoneNumber(String phoneNumber);
    Pharmacy findOneById(Integer id);
    Pharmacy findByName(String name);
    void delePharmacyById(Integer id);
}

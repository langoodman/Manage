package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.PharmacyRepository;
import com.ctgu.lan.manage.model.Pharmacy;
import com.ctgu.lan.manage.service.PharmacyRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 21:12
 * @ClassName PharmacyRepositoryServiceImpl
 * @Version 1.0.0
 */
@Service
public class PharmacyRepositoryServiceImpl implements PharmacyRepositoryService {
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    public Long countPharmacy() {
        return pharmacyRepository.count();
    }

    @Override
    public Page<Pharmacy> findAll(Pageable pageable) {
        return pharmacyRepository.findAll(pageable);
    }

    @Override
    public Pharmacy updatePharmacyInfo(Pharmacy pharmacy) {
        return pharmacyRepository.saveAndFlush(pharmacy);
    }

    @Override
    public Pharmacy addPharmacyInfo(Pharmacy pharmacy) {
        return pharmacyRepository.saveAndFlush(pharmacy);
    }

    @Override
    public Pharmacy findByPhoneNumber(String phoneNumber) {
        return pharmacyRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Pharmacy findOneById(Integer id) {
        return pharmacyRepository.findOneById(id);
    }

    @Override
    public Pharmacy findByName(String name) {
        return pharmacyRepository.findByName(name);
    }

    @Override
    public void delePharmacyById(Integer id) {
        pharmacyRepository.deleteById(id);
    }
}

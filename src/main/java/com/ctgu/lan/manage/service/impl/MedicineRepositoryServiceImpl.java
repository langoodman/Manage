package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.MedicineRepository;
import com.ctgu.lan.manage.model.Medicine;
import com.ctgu.lan.manage.service.MedicineRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 8:19
 * @ClassName MedicineRepositoryServiceImpl
 * @Version 1.0.0
 */
@Service
public class MedicineRepositoryServiceImpl implements MedicineRepositoryService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Long countMedicine() {
        return medicineRepository.count();
    }

    @Override
    public Page<Medicine> findAll(Pageable pageable) {
        return medicineRepository.findAll(pageable);
    }

    @Override
    public Medicine updateMedicineInfo(Medicine medicine) {
        return medicineRepository.saveAndFlush(medicine);
    }

    @Override
    public Medicine addMedicineInfo(Medicine medicine) {
        return medicineRepository.saveAndFlush(medicine);
    }

    @Override
    public Medicine findOneById(Integer id) {
        return medicineRepository.findOneById(id);
    }

    @Override
    public Medicine findByName(String name) {
        return medicineRepository.findByName(name);
    }

    @Override
    public void deleMedicineById(Integer id) {
        medicineRepository.deleteById(id);
    }
}

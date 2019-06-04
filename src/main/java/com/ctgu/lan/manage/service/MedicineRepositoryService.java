package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 8:18
 * @ClassName MedicineRepositoryService
 * @Version 1.0.0
 */
public interface MedicineRepositoryService {
    Long countMedicine();
    Page<Medicine> findAll(Pageable pageable);
    Medicine updateMedicineInfo(Medicine medicine);
    Medicine addMedicineInfo(Medicine medicine);
    Medicine findOneById(Integer id);
    Medicine findByName(String name);
    void deleMedicineById(Integer id);
}

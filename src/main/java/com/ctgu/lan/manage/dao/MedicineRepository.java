package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 8:17
 * @ClassName MedicineRepository
 * @Version 1.0.0
 */
public interface MedicineRepository extends JpaRepository<Medicine , Integer> {
    Page<Medicine> findAll(Pageable pageable);
    Medicine findByName(String name);
    Medicine findOneById(Integer id );
    void deleteById(Integer id);
}

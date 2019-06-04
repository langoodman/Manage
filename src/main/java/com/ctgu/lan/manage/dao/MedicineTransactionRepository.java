package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.MedicineTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 19:48
 * @ClassName MedicineTransactionRepository
 * @Version 1.0.0
 */
public interface MedicineTransactionRepository extends JpaRepository<MedicineTransaction , Integer> {
    Page<MedicineTransaction> findAll(Pageable pageable);
    MedicineTransaction findOneById(Integer id );
    MedicineTransaction findOneByMedicineName(String medicineName );
    void deleteById(Integer id);
}

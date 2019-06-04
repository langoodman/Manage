package com.ctgu.lan.manage.service;

import com.ctgu.lan.manage.model.MedicineTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 19:49
 * @ClassName MedicineTransactionRepositoryService
 * @Version 1.0.0
 */
public interface MedicineTransactionRepositoryService {
    Long countMedicineTransaction();
    Page<MedicineTransaction> findAll(Pageable pageable);
    MedicineTransaction updateMedicineTransactionInfo(MedicineTransaction medicineTransaction);
    MedicineTransaction addMedicineTransactionInfo(MedicineTransaction medicineTransaction);
    MedicineTransaction findOneById(Integer id);
    MedicineTransaction findOneByMedicineName(String medicineName );
    void deleOrdersById(Integer id);
}

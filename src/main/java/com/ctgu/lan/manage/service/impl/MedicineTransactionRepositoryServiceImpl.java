package com.ctgu.lan.manage.service.impl;

import com.ctgu.lan.manage.dao.MedicineTransactionRepository;
import com.ctgu.lan.manage.model.MedicineTransaction;
import com.ctgu.lan.manage.service.MedicineTransactionRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 19:50
 * @ClassName MedicineTransactionRepositoryServiceImpl
 * @Version 1.0.0
 */
@Service
public class MedicineTransactionRepositoryServiceImpl implements MedicineTransactionRepositoryService {
    @Autowired
    private MedicineTransactionRepository medicineTransactionRepository;

    @Override
    public Long countMedicineTransaction() {
        return medicineTransactionRepository.count();
    }

    @Override
    public Page<MedicineTransaction> findAll(Pageable pageable) {
        return medicineTransactionRepository.findAll(pageable);
    }

    @Override
    public MedicineTransaction updateMedicineTransactionInfo(MedicineTransaction medicineTransaction) {
        return medicineTransactionRepository.saveAndFlush(medicineTransaction);
    }

    @Override
    public MedicineTransaction addMedicineTransactionInfo(MedicineTransaction medicineTransaction) {
        return medicineTransactionRepository.saveAndFlush(medicineTransaction);
    }

    @Override
    public MedicineTransaction findOneById(Integer id) {
        return medicineTransactionRepository.findOneById(id);
    }

    @Override
    public MedicineTransaction findOneByMedicineName(String medicineName) {
        return medicineTransactionRepository.findOneByMedicineName(medicineName);
    }

    @Override
    public void deleOrdersById(Integer id) {
        medicineTransactionRepository.deleteById(id);
    }
}

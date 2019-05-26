package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.MedicineTransaction;
import java.util.List;

public interface MedicineTransactionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicineTransaction record);

    MedicineTransaction selectByPrimaryKey(Integer id);

    List<MedicineTransaction> selectAll();

    int updateByPrimaryKey(MedicineTransaction record);
}
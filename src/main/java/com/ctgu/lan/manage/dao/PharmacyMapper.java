package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Pharmacy;
import java.util.List;

public interface PharmacyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pharmacy record);

    Pharmacy selectByPrimaryKey(Integer id);

    List<Pharmacy> selectAll();

    int updateByPrimaryKey(Pharmacy record);
}
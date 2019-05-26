package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Medicine;
import java.util.List;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medicine record);

    Medicine selectByPrimaryKey(Integer id);

    List<Medicine> selectAll();

    int updateByPrimaryKey(Medicine record);
}
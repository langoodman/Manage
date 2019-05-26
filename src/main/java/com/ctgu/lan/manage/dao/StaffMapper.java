package com.ctgu.lan.manage.dao;

import com.ctgu.lan.manage.model.Staff;
import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    Staff selectByPrimaryKey(Integer id);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);
}
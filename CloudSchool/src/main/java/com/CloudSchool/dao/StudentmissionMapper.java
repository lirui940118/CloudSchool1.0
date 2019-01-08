package com.CloudSchool.dao;

import com.CloudSchool.domain.Studentmission;

public interface StudentmissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Studentmission record);

    int insertSelective(Studentmission record);

    Studentmission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Studentmission record);

    int updateByPrimaryKey(Studentmission record);
}
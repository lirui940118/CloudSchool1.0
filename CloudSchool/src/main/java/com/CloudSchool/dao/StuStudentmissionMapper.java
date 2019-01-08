package com.CloudSchool.dao;

import com.CloudSchool.domain.StuStudentmission;

public interface StuStudentmissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuStudentmission record);

    int insertSelective(StuStudentmission record);

    StuStudentmission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuStudentmission record);

    int updateByPrimaryKey(StuStudentmission record);
}
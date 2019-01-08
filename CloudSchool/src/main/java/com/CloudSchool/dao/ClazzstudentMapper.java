package com.CloudSchool.dao;

import com.CloudSchool.domain.Clazzstudent;

public interface ClazzstudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazzstudent record);

    int insertSelective(Clazzstudent record);

    Clazzstudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazzstudent record);

    int updateByPrimaryKey(Clazzstudent record);
}
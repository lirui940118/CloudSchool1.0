package com.CloudSchool.dao;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzstudent;

public interface ClazzstudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazzstudent record);

    int insertSelective(Clazzstudent record);

    Clazzstudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazzstudent record);

    int updateByPrimaryKey(Clazzstudent record);
    //自定义-批量新增-学生
    int insertAll(ClazzInfo record);
}
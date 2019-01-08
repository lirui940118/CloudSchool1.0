package com.CloudSchool.dao;

import com.CloudSchool.domain.Clazzcourseteacher;

public interface ClazzcourseteacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazzcourseteacher record);

    int insertSelective(Clazzcourseteacher record);

    Clazzcourseteacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazzcourseteacher record);

    int updateByPrimaryKey(Clazzcourseteacher record);
}
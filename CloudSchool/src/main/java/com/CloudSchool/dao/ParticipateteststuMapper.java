package com.CloudSchool.dao;

import com.CloudSchool.domain.Participateteststu;

public interface ParticipateteststuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participateteststu record);

    int insertSelective(Participateteststu record);

    Participateteststu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participateteststu record);

    int updateByPrimaryKey(Participateteststu record);
}
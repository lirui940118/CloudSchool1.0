package com.CloudSchool.dao;

import com.CloudSchool.domain.Phases;

public interface PhasesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Phases record);

    int insertSelective(Phases record);

    Phases selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Phases record);

    int updateByPrimaryKey(Phases record);
}
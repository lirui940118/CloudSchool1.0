package com.CloudSchool.dao;

import com.CloudSchool.domain.Participationworkclass;

public interface ParticipationworkclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participationworkclass record);

    int insertSelective(Participationworkclass record);

    Participationworkclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participationworkclass record);

    int updateByPrimaryKey(Participationworkclass record);
}
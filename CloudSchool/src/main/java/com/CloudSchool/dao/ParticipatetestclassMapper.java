package com.CloudSchool.dao;

import com.CloudSchool.domain.Participatetestclass;

public interface ParticipatetestclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participatetestclass record);

    int insertSelective(Participatetestclass record);

    Participatetestclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participatetestclass record);

    int updateByPrimaryKey(Participatetestclass record);
}
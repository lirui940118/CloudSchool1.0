package com.CloudSchool.dao;

import com.CloudSchool.domain.GkKaoqin;

public interface GkKaoqinMapper {
    int deleteByPrimaryKey(Integer kqId);

    int insert(GkKaoqin record);

    int insertSelective(GkKaoqin record);

    GkKaoqin selectByPrimaryKey(Integer kqId);

    int updateByPrimaryKeySelective(GkKaoqin record);

    int updateByPrimaryKey(GkKaoqin record);
}
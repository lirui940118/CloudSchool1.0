package com.CloudSchool.dao;

import com.CloudSchool.domain.GkKaoqinState;

public interface GkKaoqinStateMapper {
    int deleteByPrimaryKey(Integer kqStateId);

    int insert(GkKaoqinState record);

    int insertSelective(GkKaoqinState record);

    GkKaoqinState selectByPrimaryKey(Integer kqStateId);

    int updateByPrimaryKeySelective(GkKaoqinState record);

    int updateByPrimaryKey(GkKaoqinState record);
}
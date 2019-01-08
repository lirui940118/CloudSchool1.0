package com.CloudSchool.dao;

import com.CloudSchool.domain.TeaTeachermission;

public interface TeaTeachermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeaTeachermission record);

    int insertSelective(TeaTeachermission record);

    TeaTeachermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeaTeachermission record);

    int updateByPrimaryKey(TeaTeachermission record);
}
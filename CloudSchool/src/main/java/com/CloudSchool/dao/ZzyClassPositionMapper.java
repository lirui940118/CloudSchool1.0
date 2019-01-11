package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyClassPosition;

public interface ZzyClassPositionMapper {
    int insert(ZzyClassPosition record);

    int insertSelective(ZzyClassPosition record);
}
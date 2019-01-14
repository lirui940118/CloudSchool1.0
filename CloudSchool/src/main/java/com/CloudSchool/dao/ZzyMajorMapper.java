package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ZzyMajor;

public interface ZzyMajorMapper {
    int insert(ZzyMajor record);

    int insertSelective(ZzyMajor record);
    
    int insertList(List<ZzyMajor> list);
    
    public List<ZzyMajor> queryAll();
}
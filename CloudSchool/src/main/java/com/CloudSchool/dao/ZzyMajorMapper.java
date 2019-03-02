package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import com.CloudSchool.domain.ZzyMajor;

public interface ZzyMajorMapper {
    int insert(ZzyMajor record);

    int insertSelective(ZzyMajor record);
    
    int insertList(Map<String,Object> map);
    
    public List<ZzyMajor> queryAll(Integer vid);
}
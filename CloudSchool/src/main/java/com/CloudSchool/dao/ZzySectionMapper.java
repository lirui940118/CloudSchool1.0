package com.CloudSchool.dao;

import java.util.Map;

import com.CloudSchool.domain.ZzySection;

public interface ZzySectionMapper {
    int insert(ZzySection record);

    int insertSelective(ZzySection record);
    
    int insertMap(Map<String,Object> map);
    
    
}
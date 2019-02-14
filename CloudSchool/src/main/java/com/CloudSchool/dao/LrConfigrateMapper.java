package com.CloudSchool.dao;

import com.CloudSchool.domain.LrConfigrate;

public interface LrConfigrateMapper {
    int insert(LrConfigrate record);

    int insertSelective(LrConfigrate record);
    
    Integer updateAllConfig(LrConfigrate lrConfigrate);
    
    public LrConfigrate queryAllConfig();
}
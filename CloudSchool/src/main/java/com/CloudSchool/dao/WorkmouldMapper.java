package com.CloudSchool.dao;

import com.CloudSchool.domain.Workmould;

public interface WorkmouldMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workmould record);

    int insertSelective(Workmould record);

    Workmould selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workmould record);

    int updateByPrimaryKey(Workmould record);
    
    Integer[] queryWorkMouldType(Workmould obj);
}
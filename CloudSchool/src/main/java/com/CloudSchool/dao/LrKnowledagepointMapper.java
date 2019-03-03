package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.LrKnowledagepoint;

public interface LrKnowledagepointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LrKnowledagepoint record);

    int insertSelective(LrKnowledagepoint record);

    LrKnowledagepoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LrKnowledagepoint record);

    int updateByPrimaryKey(LrKnowledagepoint record);
    
    List<LrKnowledagepoint>  queryBySid(Integer sid);
}
package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import com.CloudSchool.domain.ZzySection;

public interface ZzySectionMapper {
    int insert(ZzySection record);

    int insertSelective(ZzySection record);
    
    int insertMap(Map<String,Object> map);
    
    public List<ZzySection> queryBycid(Integer cid);
    
    List<ZzySection> queryAllSection();
}
package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import com.CloudSchool.domain.ZzyMajor;

public interface ZzyMajorMapper {
	//gk根据版本id查询所有专业
	List<ZzyMajor> queryAllZYByBB(String user1);
	
	
	
    int insert(ZzyMajor record);

    int insertSelective(ZzyMajor record);
    
    int insertList(Map<String,Object> map);
    
    public List<ZzyMajor> queryAll();
    
    public List<ZzyMajor> queryAll2(Integer vid);
    
}
package com.CloudSchool.service;

import java.util.List;
import java.util.Map;

import com.CloudSchool.domain.ZzyMajor;

public interface ZzyMajorService {
	//循环添加专业
	int insertList(Map<String,Object> map);
	
	//根据版本id查询所有专业
	public List<ZzyMajor> queryAll();
	
	public List<ZzyMajor> queryAll2(Integer vid);
}

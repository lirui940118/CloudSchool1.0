package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyMajor;

public interface ZzyMajorService {
	//循环添加专业
	public int insertList(List<ZzyMajor> list);
	
	//查询所有专业
	public List<ZzyMajor> queryAll();
}

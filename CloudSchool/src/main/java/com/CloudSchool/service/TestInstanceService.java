package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyGrade;

public interface TestInstanceService {
	
	public List<ZzyGrade> queryGrade(String id);
	
	public Object queryClass(Integer id,Integer sid,Integer cur,Integer pagesize,Integer cid);
	
	public List<ZzyGrade> queryAll();
}

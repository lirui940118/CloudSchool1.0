package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.zjfvo.TestPublishParam;

public interface TestInstanceService {
	
	public List<ZzyGrade> queryGrade(String id);
	
	public Object queryClass(Integer id,Integer sid,Integer cur,Integer pagesize,Integer cid);
	
	public List<ZzyGrade> queryAll();
	
	public int testPublish(TestPublishParam obj);
}

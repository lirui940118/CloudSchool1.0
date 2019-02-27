package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.zjfvo.StuTestInfo;
import com.CloudSchool.domain.zjfvo.TestInfo;

public interface ParticipateteststuService {
	List<StuTestInfo> queryStuTestAllBySid(Integer sid);
	
	TestInfo  queryTestInfoBySidAndTid(Integer id,Integer sid);
}

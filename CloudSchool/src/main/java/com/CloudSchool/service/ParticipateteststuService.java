package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.zjfvo.StuTestInfo;
import com.CloudSchool.domain.zjfvo.TestInfo;

public interface ParticipateteststuService {
	List<StuTestInfo> queryStuTestAllBySid(Integer sid);
	
	TestInfo  queryTestInfoBySidAndTid(Integer id,Integer sid);
	 public PageBean queryTestInfoBySidAndTidCorrect(Integer id,Integer sid,Integer cur,Integer pagesize);
	 /*查询该场考试是否缺考  0为缺考 其他为正常参加考试 write by lirui*/
	boolean queryIsTestBySidAndTid(Integer sId,Integer tId);
}

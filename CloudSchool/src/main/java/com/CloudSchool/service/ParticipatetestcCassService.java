package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.zjfvo.TeachTestCorrect;
import com.CloudSchool.domain.zjfvo.TestInfoAll;

public interface ParticipatetestcCassService {
	List<TeachTestCorrect> queryMyCorrectTest(Integer uid);
	
	 List<TestInfoAll> queryByTidTestInfo(Integer tid,Integer cid);
	 
	 public int updateTestClassStatus(Participatetestclass obj);
	 
	
}

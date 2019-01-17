package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;

public interface GkFangTanService {
	//查询所有访谈
	GkPageBean<GkInterview> queryAllFangTan(GkInterview ft);
	//同过访谈id查询访谈详情
	GkInterview queryFangTanDetailsByftid(Integer ftid);
	//通过访谈id删除访谈
	int deleteFangTanByftId(int[] shuzu);
	//新增访谈
	int insertFangTan(GkInterview ft);
}

package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;
import com.CloudSchool.domain.GkPageBean;

public interface GkFangTanService {
	//查询所有访谈
	GkPageBean<GkInterview> queryAllFangTan(GkFangTan ft);
	
}

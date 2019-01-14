package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkFangTan;
import com.CloudSchool.domain.GkInterview;

public interface GkInterviewMapper {
	
	//查询所有访谈记录
	List<GkInterview> queryAllFangTan(GkFangTan ft);
	//查询所有访谈记录行数
	int queryAllFangTanCount(GkFangTan ft);
	//通过访谈id查询访谈详情
	GkInterview queryFangTanDetailsByftid(Integer ftid);
	
    int deleteByPrimaryKey(Integer ftId);

    int insert(GkInterview record);

    int insertSelective(GkInterview record);

    GkInterview selectByPrimaryKey(Integer ftId);

    int updateByPrimaryKeySelective(GkInterview record);

    int updateByPrimaryKey(GkInterview record);
}
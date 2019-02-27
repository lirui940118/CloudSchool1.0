package com.CloudSchool.dao;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkWjtmFk;

public interface GkWjtmFkMapper {
	//新增问卷题目关联表
	int insertWJTMFK(@Param("shuzu")Integer[] shuzu,@Param("wjId")Integer wjId);
	
    int deleteByPrimaryKey(Integer fkId);

    int insert(GkWjtmFk record);

    int insertSelective(GkWjtmFk record);

    GkWjtmFk selectByPrimaryKey(Integer fkId);

    int updateByPrimaryKeySelective(GkWjtmFk record);

    int updateByPrimaryKey(GkWjtmFk record);
}
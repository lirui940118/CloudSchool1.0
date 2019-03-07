package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.GkWjcs;

public interface GkWjcsMapper {
	//完善问卷选择
	int updateWjcs(GkWjcs wj);
	//新增问卷测试记录（选择题）
	int insertWjcs(@Param("quanbulist")List<CqjUser> quanbulist,@Param("wjId")Integer wjId);
	
	
	
    int deleteByPrimaryKey(Integer wjcsId);

    int insert(GkWjcs record);

    int insertSelective(GkWjcs record);

    GkWjcs selectByPrimaryKey(Integer wjcsId);

    int updateByPrimaryKeySelective(GkWjcs record);

    int updateByPrimaryKey(GkWjcs record);
}
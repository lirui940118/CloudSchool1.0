package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkQuestionnairetm;

public interface GkQuestionnairetmMapper {
	//新增题目 
	int insertTiMu(GkQuestionnairetm tm);
	//通过问卷类型，选项类型查询题目
	List<GkQuestionnairetm> queryAllTiMuByXXandwj(@Param("xx")Integer xx,@Param("wj")Integer wj);
	
	
    int deleteByPrimaryKey(Integer wjtmId);

    int insert(GkQuestionnairetm record);

    int insertSelective(GkQuestionnairetm record);

    GkQuestionnairetm selectByPrimaryKey(Integer wjtmId);

    int updateByPrimaryKeySelective(GkQuestionnairetm record);

    int updateByPrimaryKey(GkQuestionnairetm record);
}
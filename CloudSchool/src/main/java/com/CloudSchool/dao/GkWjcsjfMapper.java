package com.CloudSchool.dao;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.GkWjcsjf;

public interface GkWjcsjfMapper {
    int deleteByPrimaryKey(Integer wjcsjfId);

    int insert(GkWjcsjf record);

    int insertSelective(GkWjcsjf record);

    GkWjcsjf selectByPrimaryKey(Integer wjcsjfId);

    int updateByPrimaryKeySelective(GkWjcsjf record);

    int updateByPrimaryKey(GkWjcsjf record);
    
    /* 能力问卷调查，评分  统计使用*/
    Integer queryAbilitWjBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId,@Param("tId") Integer tId);
}
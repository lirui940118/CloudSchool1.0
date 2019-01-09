package com.CloudSchool.dao;

import org.apache.ibatis.annotations.Mapper;

import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ClazzInfo;


@Mapper
public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClazzInfo record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);
}
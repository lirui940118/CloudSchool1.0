package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.CloudSchool.domain.Classtype;
@Mapper
public interface ClasstypeMapper {
	List<Classtype> query();
    int deleteByPrimaryKey(Integer id);

    int insert(Classtype record);

    int insertSelective(Classtype record);

    Classtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classtype record);

    int updateByPrimaryKey(Classtype record);
}
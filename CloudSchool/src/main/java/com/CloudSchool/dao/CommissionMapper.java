package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.CloudSchool.domain.Commission;
@Mapper
public interface CommissionMapper {
	List<Commission> query(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Commission record);

    int insertSelective(Commission record);

    Commission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commission record);

    int updateByPrimaryKey(Commission record);
}
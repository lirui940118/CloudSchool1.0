package com.CloudSchool.dao;

import com.CloudSchool.domain.CqjStudent;

public interface CqjStudentMapper {
	//write by lirui
	//查询学员信息
	public CqjStudent queryStudentInfoBySid(Integer sId);
	
	
    int deleteByPrimaryKey(Integer studentid);

    int insert(CqjStudent record);

    int insertSelective(CqjStudent record);

    CqjStudent selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(CqjStudent record);

    int updateByPrimaryKey(CqjStudent record);
}
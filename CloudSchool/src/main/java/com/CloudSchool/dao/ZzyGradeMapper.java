package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ZzyGrade;

public interface ZzyGradeMapper {
	
	//查询该学员所读过的年级 write by lirui
	public List<ZzyGrade> queryGradeListBySid(Integer sId);
	//查询该学员当前在读年级
	public ZzyGrade queryCurrentGradeBySid(Integer sId);
	
	
    int deleteByPrimaryKey(Integer gid);

    int insert(ZzyGrade record);

    int insertSelective(ZzyGrade record);

    ZzyGrade selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(ZzyGrade record);

    int updateByPrimaryKey(ZzyGrade record);
}
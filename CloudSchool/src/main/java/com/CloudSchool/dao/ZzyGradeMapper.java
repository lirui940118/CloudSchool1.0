package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import com.CloudSchool.domain.ZzyGrade;

public interface ZzyGradeMapper {
	
	//查询该学员所读过的年级 write by lirui
	public List<ZzyGrade> queryGradeListBySid(Integer sId);
	//查询该学员当前在读年级
	public ZzyGrade queryCurrentGradeBySid(Integer sId);
	//循环新增年级
	public int insertMap(Map<String,Object> map);
	//根据版本id查询年级
	public List<ZzyGrade> queryByvid(Integer vid);
	public List<ZzyGrade> queryByvid2(Integer vid);
	//查询所有年级
	public List<ZzyGrade> queryAll();
	

	
    int deleteByPrimaryKey(Integer gid);

    int insert(ZzyGrade record);

    int insertSelective(ZzyGrade record);

    ZzyGrade selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(ZzyGrade record);

    int updateByPrimaryKey(ZzyGrade record);
}
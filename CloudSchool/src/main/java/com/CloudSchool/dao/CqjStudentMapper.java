package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.CqjStudent;

public interface CqjStudentMapper {
	
	//gk通过学生id查询所在班级所有学生
	public List<CqjStudent> queryTongXueByUserid(Integer uid);
	//write by lirui
	//查询学员信息
	public CqjStudent queryStudentInfoBySid(Integer sId);
	
	
    int deleteByPrimaryKey(Integer studentid);

    int insert(CqjStudent record);

    int insertSelective(CqjStudent record);

    CqjStudent selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(CqjStudent record);

    int updateByPrimaryKey(CqjStudent record);
    
    //根据学员id查询学员对象
    public CqjStudent queryBysid(Integer cid);
}
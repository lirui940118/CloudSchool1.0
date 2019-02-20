package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzstudent;

public interface ClazzstudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazzstudent record);

    int insertSelective(Clazzstudent record);

    Clazzstudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazzstudent record);

    int updateByPrimaryKey(Clazzstudent record);
    //自定义-批量新增-学生
    int insertAll(ClazzInfo record);
    
    //根据班级id查询该班级的学生
    public List<Clazzstudent> queryByMo(Integer cid);
    
    //根据年级id 查询从这个班级游离出去的学员对象以及现在所在的班级
    public List<Clazzstudent> queryZc(Integer cid);
    
    //查询所有状态为游离未分配的学员
    public List<Clazzstudent> queryBystatus();
    
    //根据id 将状态改为4(游离已分配)
    public int updateByid(Clazzstudent record);
    
    //在一个班级中添加一个学员
    public int insertOne(Clazzstudent record);
	
    //查询一个班级中所有正常的学员
    public List<Clazzstudent> queryBystatusAndid(Integer cid);
   
}
package com.CloudSchool.dao;

import java.util.List;

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
    
    //根据年级id查询班级
    public List<Clazz> queryBygid(Integer gid);
    
    //根据班级id集合 查询班级数据
    public List<Clazz> queryListid(List<String> list);
}
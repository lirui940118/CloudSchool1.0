package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.statistics.ClazzBaseInfoVO;
import com.CloudSchool.domain.statistics.StudentInfoVO;


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
    
    //根据班级id查询班级 以及查询班主任对象以及教员集合
    public Clazz queryByid(Integer id);

    //根据班级id 查询班级
    public Clazz queryZcid(Integer cid);

    //write by lirui 查询班级基础信息(统计lirui)
    public List<ClazzBaseInfoVO> queryClazzBaseInfo(Integer clazzId);
}
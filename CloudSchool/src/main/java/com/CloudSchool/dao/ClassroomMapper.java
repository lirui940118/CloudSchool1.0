package com.CloudSchool.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Classroom;
@Mapper
public interface ClassroomMapper {
	List<Classroom> query();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
    
    //查询所有上课的教室
    public List<Classroom> queryAllRoom();
    
    //查询某日期 某时间区间 某教室是否被占用
    public Integer queryOccupyRoom(@Param("rid")Integer rid,@Param("time")Date time,@Param("temporal_interva") Integer temporal_interva);
    
    //查询所有自习的教室
    public List<Classroom>queryAllZiXiRoom();
    
    //根据教室id查询教室对象
    public Classroom queryByroomid(Integer id);
    
    //查询某一天空教室(赵举峰)
    int queryBytimeRoom(@Param("rid")Integer rid,@Param("time")Date time);
    
}
package com.CloudSchool.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Participationworkclass;

public interface ParticipationworkclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participationworkclass record);

    int insertSelective(Participationworkclass record);

    Participationworkclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participationworkclass record);

    int updateByPrimaryKey(Participationworkclass record);
    
    int insertObjList(Map<String, Object> obj);
    
    int insertObj(Participationworkclass wid);
    
    int updateStatusById(Participationworkclass obj);
    
    int updateStatusList(@Param("stauts")Integer status,@Param("wid")Integer wid);
}
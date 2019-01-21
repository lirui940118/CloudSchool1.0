package com.CloudSchool.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Participationworkstu;

public interface ParticipationworkstuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participationworkstu record);

    int insertSelective(Participationworkstu record);

    Participationworkstu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participationworkstu record);

    int updateByPrimaryKey(Participationworkstu record);
    
    int insertList(Map<String, Object> map);
    int updateIscorrectByid(@Param("isCorrect")Integer isCorrect,@Param("id")Integer id,@Param("sid") Integer sid);
}
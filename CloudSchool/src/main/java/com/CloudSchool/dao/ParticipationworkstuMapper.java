package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Participationworkstu;
import com.CloudSchool.domain.zjfvo.StuWorkInfo;
import com.CloudSchool.domain.zjfvo.StudentWork;
import com.CloudSchool.domain.zjfvo.WorkinstanceInfo;

public interface ParticipationworkstuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participationworkstu record);

    int insertSelective(Participationworkstu record);

    Participationworkstu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participationworkstu record);

    int updateByPrimaryKey(Participationworkstu record);
    
    int insertList(Map<String, Object> map);
    int updateIscorrectByid(@Param("isCorrect")Integer isCorrect,@Param("id")Integer id,@Param("sid") Integer sid);
    
    List<WorkinstanceInfo> queryByCidAndWidShowInfo(@Param("cid")Integer cid,@Param("wid")Integer wid);
    
    //wid  作业id    学生id  sid
    StuWorkInfo queryStuWorkInfo(@Param("wid")Integer wid,@Param("sid")Integer sid,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize);
    
    int queryStuWorkInfoCount(@Param("wid")Integer wid,@Param("sid")Integer sid);
    
    int queryNotCorrectCountByUser1(Participationworkstu obj);
    
    
    //根据学生id查询所有的作业
    List<StudentWork> queryStuWorkBySid(@Param("sid")Integer sid,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize,@Param("isCorrect")Integer isCorrect);
    
    //根据学生id查询所有的作业Count
    int queryStuWorkBySidCount(@Param("sid")Integer sid,@Param("isCorrect")Integer isCorrect);
}
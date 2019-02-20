package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.statistics.BadTopicVO;

public interface WtrecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wtrecord record);

    int insertSelective(Wtrecord record);

    Wtrecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wtrecord record);

    int updateByPrimaryKeyWithBLOBs(Wtrecord record);

    int updateByPrimaryKey(Wtrecord record);
    
    int insertWorkRecordList(List<Wtrecord> list);
    int deleteBySidAndWid(@Param("wid") Integer wid,@Param("sid") Integer sid);
    
    
  /*   根据血学生id,作业查询所有选择题记录和题目的正确答案 */
    List<Wtrecord> queryByWidAndSidAllSelect(@Param("wid") Integer wid,@Param("sid") Integer sid);
    
    
    int updateScoreById(@Param("score") Integer score,@Param("id") Integer id);
    
    int queryByWidAndSidSumScore(@Param("wid") Integer wid,@Param("sid") Integer sid);
    
    //write by lirui 查询学员的劣势知识点 (作业和考试)
    public List<BadTopicVO> queryBadKnowledagePointBySid(Integer sId);
    
    public Wtrecord queryTopicById(Integer id);
    
    //老师手动批改作业给分
    public int updateScoreByWidSidTid(Wtrecord obj);
}	
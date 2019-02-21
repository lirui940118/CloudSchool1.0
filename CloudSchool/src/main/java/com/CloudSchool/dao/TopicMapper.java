package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Topic;
import com.CloudSchool.domain.TopicWithBLOBs;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicWithBLOBs record);
    /*添加题目*/
    int insertSelective(TopicWithBLOBs record);

    TopicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TopicWithBLOBs record);

    int updateByPrimaryKey(Topic record);
    int queryCount(Topic obj);
    List<Topic> conditionsQueryTopci(@Param("obj")Topic obj,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize);

    /*当前课程进度下应该答题总数*/
    Integer queryCurrentTotalTopicCountBysIdAndGid(@Param("sId") Integer sId,@Param("gId") Integer gId,@Param("eId") Integer eId);
    /*当前课程进度下学员的实际答题量*/
    Integer queryCurrentRealTotalTopicCountBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId,@Param("eId") Integer eId);
    /*当前进度下刷题正确率*/
    Integer queryCurrentTotalTopicAccuracyBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId,@Param("eId") Integer eId);
    /*当前进度下，上机题目正确率*/
    Integer queryApplicationAbilityRateBysIdAndgId(@Param("sId") Integer sId,@Param("gId") Integer gId,@Param("tId") Integer tId);
    
    //根据题目id查询题目
    TopicWithBLOBs queryTopicById(Integer id);
}
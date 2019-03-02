package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.zjfvo.PublishWorkInfo;

public interface WorkinstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workinstance record);

    int insertSelective(Workinstance record);

    Workinstance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workinstance record);

    int updateByPrimaryKey(Workinstance record);
    /*根据教师id查询发布的作业 */
    List<PublishWorkInfo> queryPublishWorkByTid(@Param("tid")Integer tid,@Param("wStatus") Integer wStatus,@Param("pageSize")Integer pageSize,@Param("cur")Integer cur);
    /*根据教师id查询发布的作业 Count*/
    int queryPublishWorkByTidCount(@Param("tid")Integer tid,@Param("wStatus") Integer wStatus);
    
    //根据作业id查询参加本次作业的完成情况
    Workinstance queryWorkStuInfo(Integer id);
    
    int querySumScoreById(Integer id);
    
   
}
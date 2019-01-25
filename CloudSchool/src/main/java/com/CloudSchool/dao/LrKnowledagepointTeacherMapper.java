package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.LrKnowledagepointTeacher;
import com.CloudSchool.domain.statistics.KnowledgePointUpVO;

public interface LrKnowledagepointTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LrKnowledagepointTeacher record);

    int insertSelective(LrKnowledagepointTeacher record);

    LrKnowledagepointTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LrKnowledagepointTeacher record);

    int updateByPrimaryKey(LrKnowledagepointTeacher record);
    //查询该教员知识点的上报情况
    public List<KnowledgePointUpVO> queryAllKnowledagepointByStaffId(Integer staffId);
}
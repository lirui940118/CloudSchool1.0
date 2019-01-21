package com.CloudSchool.dao;

import com.CloudSchool.domain.LrKnowledagepointTeacher;

public interface LrKnowledagepointTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LrKnowledagepointTeacher record);

    int insertSelective(LrKnowledagepointTeacher record);

    LrKnowledagepointTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LrKnowledagepointTeacher record);

    int updateByPrimaryKey(LrKnowledagepointTeacher record);
}
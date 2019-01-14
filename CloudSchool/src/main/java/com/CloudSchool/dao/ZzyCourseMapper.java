package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ZzyCourse;

public interface ZzyCourseMapper {
    int insert(ZzyCourse record);

    int insertSelective(ZzyCourse record);
    
    public List<ZzyCourse> queryBygid(Integer gid);
}
package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyGrade;

public interface ZzyGradeMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(ZzyGrade record);

    int insertSelective(ZzyGrade record);

    ZzyGrade selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(ZzyGrade record);

    int updateByPrimaryKey(ZzyGrade record);
}
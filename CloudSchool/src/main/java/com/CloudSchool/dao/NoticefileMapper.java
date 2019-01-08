package com.CloudSchool.dao;

import com.CloudSchool.domain.Noticefile;

public interface NoticefileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Noticefile record);

    int insertSelective(Noticefile record);

    Noticefile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Noticefile record);

    int updateByPrimaryKey(Noticefile record);
}
package com.CloudSchool.dao;

import com.CloudSchool.domain.Noticeimg;

public interface NoticeimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Noticeimg record);

    int insertSelective(Noticeimg record);

    Noticeimg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Noticeimg record);

    int updateByPrimaryKey(Noticeimg record);
}
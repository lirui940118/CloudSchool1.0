package com.CloudSchool.dao;

import com.CloudSchool.domain.ZzyVersion;

public interface ZzyVersionMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(ZzyVersion record);

    int insertSelective(ZzyVersion record);

    ZzyVersion selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(ZzyVersion record);

    int updateByPrimaryKey(ZzyVersion record);
}
package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.ZzyVersion;

public interface ZzyVersionService {
	int deleteByPrimaryKey(Integer vid);

    int insert(ZzyVersion record);

    int insertSelective(ZzyVersion record);

    ZzyVersion selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(ZzyVersion record);

    int updateByPrimaryKey(ZzyVersion record);
    
    List<ZzyVersion> queryAll();
}

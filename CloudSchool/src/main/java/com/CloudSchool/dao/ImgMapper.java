package com.CloudSchool.dao;

import com.CloudSchool.domain.Img;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}
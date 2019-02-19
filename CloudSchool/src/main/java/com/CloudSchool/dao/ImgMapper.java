package com.CloudSchool.dao;

import java.util.List;

import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Img;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
    //批量分配学生的系统登录账号user的头像
    int insertAll(List<CqjUser> u);
}
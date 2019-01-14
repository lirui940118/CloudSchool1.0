package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
    
    List<Notice> query();
    CqjUser querpersonerInfo(Integer uid);

	List<Notice> query(@Param("time")String time, @Param("str")String str);
}
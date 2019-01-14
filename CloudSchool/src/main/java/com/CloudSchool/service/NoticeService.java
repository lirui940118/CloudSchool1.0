package com.CloudSchool.service;

import java.util.List;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;

public interface NoticeService {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
    
    CqjUser querpersonerInfo(Integer uid);

	List<Notice> query(String time, String str);
}

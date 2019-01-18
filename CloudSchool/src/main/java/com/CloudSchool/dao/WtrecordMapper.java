package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Wtrecord;

public interface WtrecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wtrecord record);

    int insertSelective(Wtrecord record);

    Wtrecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wtrecord record);

    int updateByPrimaryKeyWithBLOBs(Wtrecord record);

    int updateByPrimaryKey(Wtrecord record);
    
    int insertWorkRecordList(List<Wtrecord> list);
    int deleteBySidAndWid(@Param("wid") Integer wid,@Param("sid") Integer sid);
}
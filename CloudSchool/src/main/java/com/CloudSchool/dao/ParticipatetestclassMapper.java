package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.zjfvo.TeachTestCorrect;
import com.CloudSchool.domain.zjfvo.TestInfoAll;

public interface ParticipatetestclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participatetestclass record);

    int insertSelective(Participatetestclass record);

    Participatetestclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participatetestclass record);

    int updateByPrimaryKey(Participatetestclass record);
    
    int inserList(Participatetestclass obj);
    
    List<TeachTestCorrect> queryMyCorrectTest(Integer uid);
    
    List<TestInfoAll> queryByTidTestInfo(@Param("tid")Integer tid,@Param("cid")Integer cid);
    
    int updateTestStatus(Participatetestclass obj);
    
    int updateTestStatusTime(Participatetestclass obj);
}
package com.CloudSchool.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Participateteststu;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.zjfvo.CorrectTestInfo;
import com.CloudSchool.domain.zjfvo.StuTestInfo;
import com.CloudSchool.domain.zjfvo.TestInfo;

public interface ParticipateteststuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participateteststu record);

    int insertSelective(Participateteststu record);

    Participateteststu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participateteststu record);

    int updateByPrimaryKey(Participateteststu record);
    
    int insertList(Map<String, Object> obj);
    
    List<StuTestInfo> queryStuTestAllBySid(Integer sid);
    
    TestInfo  queryTestInfoBySidAndTid(@Param("id")Integer id,@Param("sid")Integer sid);
    
    int updateStatusById(@Param("user3")Integer user3,@Param("sid")Integer sid,@Param("tid")Integer tid);
    
    public List<CorrectTestInfo> queryTestInfoBySidAndTidCorrect(@Param("id")Integer id,@Param("sid")Integer sid,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize);
    
    Integer queryTestInfoBySidAndTidCorrectCount(@Param("id")Integer id,@Param("sid")Integer sid);
    
    
    int updateUser3ByTidAndSid(Participateteststu stu);
    
    Integer queryNotCorrectCountByUser1(@Param("tid")Integer tid,@Param("user1")Integer user1,@Param("user3")Integer user3);
    
    Integer[] queryByTidAndStatusAll(Integer tid);
}
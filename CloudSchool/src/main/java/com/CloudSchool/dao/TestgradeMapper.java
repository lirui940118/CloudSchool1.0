package com.CloudSchool.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Testgrade;
import com.CloudSchool.domain.statistics.TopicVo;
import com.CloudSchool.domain.statistics.testBaseInfo;
import com.CloudSchool.domain.statistics.testVO;

public interface TestgradeMapper {
	//write by leerui
	public List<testVO> querySimStudentTestGradeBySid(Integer sId,Integer gId);
	//
	public List<TopicVo> queryAllKnowledagePointBySidAndtId(@Param("sId") Integer sId,@Param("tId") Integer tId);
	
	public testBaseInfo queryTestBaseInfoBySidAndtId(@Param("sId") Integer sId,@Param("tId") Integer tId);
	
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(Testgrade record);

    int insertSelective(Testgrade record);

    Testgrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testgrade record);

    int updateByPrimaryKey(Testgrade record);
    
    int insertObj(Testgrade obj);
}
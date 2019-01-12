package com.CloudSchool.dao;



import java.util.List;

import com.CloudSchool.domain.Testgrade;
import com.CloudSchool.domain.statistics.testVO;

public interface TestgradeMapper {
	//write by leerui
	public List<testVO> querySimStudentTestGradeBySid(Integer sId,Integer gId);
	
	
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(Testgrade record);

    int insertSelective(Testgrade record);

    Testgrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testgrade record);

    int updateByPrimaryKey(Testgrade record);
}
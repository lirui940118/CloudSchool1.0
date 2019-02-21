package com.CloudSchool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.Testmodule;

public interface TestmoduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testmodule record);

    int insertSelective(Testmodule record);

    Testmodule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testmodule record);

    int updateByPrimaryKey(Testmodule record);
    
    
    //添加试卷模板
    int insertTestModule(Testmodule obj);
    //查询试卷类型
    Integer[] queryTestMouldType(Testmodule obj);
    
    List<Testmodule> queryTestModule(@Param("uid")Integer uid,@Param("cur")Integer cur,@Param("pagesize")Integer pagesize);
    
    int queryTestModuleCount(Integer uid);
}
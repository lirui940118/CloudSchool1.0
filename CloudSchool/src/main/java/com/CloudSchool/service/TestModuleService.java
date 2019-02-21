package com.CloudSchool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Testmodule;

public interface TestModuleService {
	 //添加试卷模板
    int insertTestModule(Testmodule obj);
    
    PageBean queryTestModule(Integer uid,Integer cur,Integer pagesize);
}

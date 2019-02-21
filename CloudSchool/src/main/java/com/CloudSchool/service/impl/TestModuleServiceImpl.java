package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.TestinfoMapper;
import com.CloudSchool.dao.TestmoduleMapper;
import com.CloudSchool.dao.WorkmouldMapper;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Testmodule;
import com.CloudSchool.service.TestModuleService;
@Service
@Transactional
public class TestModuleServiceImpl implements TestModuleService{
	@Autowired
	TestmoduleMapper testmoduleMapper;
	
	@Autowired
	TestinfoMapper testinfoMapper;
	 //添加试卷模板
    public int insertTestModule(Testmodule obj) {
    	//生成作业的类型    选择题 阅读题 上机题  混合题
    			Integer[] array = testmoduleMapper.queryTestMouldType(obj);
    			for (int j = 0; j < array.length; j++) {
    				/*选择题*/
    				if (array.length == 1 && array[0] == 1) {
    					obj.setUser1("0");
    					break;
    				}
    				/*阅读题*/
    				if (array.length == 1 && array[0] == 2) {
    					obj.setUser1("1");
    					break;
    				}
    				/*上机题*/
    				if (array.length == 1 && array[0] == 3) {
    					obj.setUser1("2");
    					break;
    				}
    				/*混合题*/
    				if(array.length>1) {
    					obj.setUser1("3");
    				}
    			}
    			int i=testmoduleMapper.insertTestModule(obj);
    			if(i>0) {
    				Map<String, Object> map=new HashMap<String, Object>();
    				map.put("testid", obj.getId());
    				map.put("ids", obj.getIds());
    				int result=testinfoMapper.insertList(map);
    				if(result>0) {
    					return result;
    				}
    				return 0;
    			}
    			return 0;
    }
	@Override
	public PageBean queryTestModule(Integer uid, Integer cur, Integer pagesize) {
		int datas=testmoduleMapper.queryTestModuleCount(uid);
		PageBean page=new PageBean(datas, pagesize, testmoduleMapper.queryTestModule(uid, (cur-1)*pagesize, pagesize), cur);
		return page;
	}
}

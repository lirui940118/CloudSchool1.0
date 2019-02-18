package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.ZzyCourseMapper;
import com.CloudSchool.dao.ZzySectionMapper;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.statistics.CourseVO;
import com.CloudSchool.service.ZzyCourseService;

@Service
public class ZzyCourseServiceimpl implements ZzyCourseService{
	
	@Autowired
	ZzyCourseMapper cous;

	@Autowired
	ZzySectionMapper secs;
	@Override
	public int insert(ZzyCourse record) {
		// TODO Auto-generated method stub
		//新增课程
		int i=cous.insert(record);
		//创建一个集合
		Map<String,Object> map= new HashMap<String,Object>();
		//第一个值为刚刚新建的版本的id
		map.put("cid", record.getCid());
		//第二个值为年级信息
		map.put("list", record.getList());
		//新增年级方法
		secs.insertMap(map);
		return 0;
	}
	@Override
	public List<CourseVO> queryStaffsAboutOpenClass(Integer gId, Integer mId) {
		// TODO 开办选老师
		
		return cous.queryStaffsAboutOpenClass(gId, mId);
	}
	public ZzyCourse queryBycid(Integer cid) {
		// TODO Auto-generated method stub
		return cous.queryBycid(cid);
	}
	
}

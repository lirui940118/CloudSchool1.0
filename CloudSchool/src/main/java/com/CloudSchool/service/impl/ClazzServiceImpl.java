package com.CloudSchool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.ClazzcourseteacherMapper;
import com.CloudSchool.dao.ClazzstudentMapper;
import com.CloudSchool.domain.Clazz;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzcourseteacher;
import com.CloudSchool.domain.Clazzstudent;
import com.CloudSchool.domain.statistics.ClazzBaseInfoVO;
import com.CloudSchool.service.ClazzService;
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	ClazzMapper cm;
	@Autowired
	ClazzstudentMapper csm;
	@Autowired
	ClazzcourseteacherMapper cctm;
	
	
	@Override
	public int CreateClass(ClazzInfo c) {
		int jg=cm.insert(c);
//		System.out.println(jg+"-"+c.getId()+"-"+c.getCname());
		int jg1=csm.insertAll(c);
//		System.out.println(jg+"------------------------\n\n\n\n------");
		int jg2=cctm.insertAll(c);
		System.out.println(jg1+"------------------------\n\n\n\n------");
		return jg+jg1+jg2;
	}
	/**
	 * 自动开班
	 * @return
	 */
	public int AutoCreateClass() {
		System.out.println("自动开班");
		
		return 0;
	}
	
	
	@Override
	public List<Clazz> queryListid(List<String> list) {
		// TODO Auto-generated method stub
		return cm.queryListid(list);
	}
	@Override
	public Clazz queryByid(Integer id) {
		// TODO Auto-generated method stub
		return cm.queryByid(id);
	}
	@Override
	public List<ClazzBaseInfoVO> queryClazzBaseInfo(Integer clazzId) {
		return cm.queryClazzBaseInfo(clazzId);
	}
	
	//根据班级班级id查询班级下所有学生
	@Override
	public List<Clazz> queryByClazzidAllStu(Integer[] clazzs) {
		// TODO Auto-generated method stub
		return cm.queryByClazzidAllStu(clazzs);
	}
}

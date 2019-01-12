package com.CloudSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.ClazzcourseteacherMapper;
import com.CloudSchool.dao.ClazzstudentMapper;
import com.CloudSchool.domain.ClazzInfo;
import com.CloudSchool.domain.Clazzstudent;
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
//		int jg=cm.insert(c);
//		System.out.println(jg+"-"+c.getId()+"-"+c.getCname());
//		int jg=csm.insertAll(c);
//		System.out.println(jg+"------------------------\n\n\n\n------");
		int jg1=cctm.insertAll(c);
		System.out.println(jg1+"------------------------\n\n\n\n------");
		return jg1;
	}
	/**
	 * 自动开班
	 * @return
	 */
	public int AutoCreateClass() {
		System.out.println("自动开班");
		
		return 0;
	}
}

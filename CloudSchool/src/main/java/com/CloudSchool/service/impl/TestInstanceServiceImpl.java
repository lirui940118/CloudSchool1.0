package com.CloudSchool.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ClazzMapper;
import com.CloudSchool.dao.ParticipatetestclassMapper;
import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.dao.TestinstanceMapper;
import com.CloudSchool.dao.TesttypeMapper;
import com.CloudSchool.dao.ZzyGradeMapper;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.Testtype;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.domain.zjfvo.ClazzAndStuParam;
import com.CloudSchool.domain.zjfvo.TestPublishParam;
import com.CloudSchool.domain.zjfvo.TestclassVoParam;
import com.CloudSchool.service.TestInstanceService;
import com.CloudSchool.timer.DynamicTaskJobs;
import com.CloudSchool.timer.TestStatusTaskJob;
import com.CloudSchool.timer.TestStatusTaskJobEnd;
import com.CloudSchool.timer.TestTimeEndTaskJobs;
import com.alibaba.fastjson.JSON;
@Service
@Transactional
public class TestInstanceServiceImpl implements TestInstanceService{
	
	@Autowired
	TesttypeMapper testtypeMapper;
	@Autowired
	ZzyGradeMapper zzyGradeMapper;
	
	@Autowired
	ClazzMapper clazzMapper;
	
	@Autowired
	TestinstanceMapper testinstanceMapper;
	@Autowired
	ParticipatetestclassMapper participatetestclassMapper;
	
	@Autowired
	ParticipateteststuMapper participateteststuMapper;
	
	@Autowired
	TestStatusTaskJob testStatusTaskJob;
	
	@Autowired
	DynamicTaskJobs dynamicTaskJobs;
	
	@Autowired
	TestStatusTaskJobEnd testStatusTaskJobEnd;
	
	@Autowired
	TestTimeEndTaskJobs testTimeEndTaskJobs;
	//查询所有班级  有权限
	@Override
	public List<ZzyGrade> queryGrade(String id) {
		//试卷类型
		List<Testtype> list=testtypeMapper.queryBylimits("%"+id+",%");
		for (Testtype obj : list) {
			if(obj.getId()>1) {
				return zzyGradeMapper.queryAll();
			}
		}
		return null;
	}

	@Override
	public Object queryClass(Integer id, Integer sid, Integer cur, Integer pagesize, Integer cid) {
		if(id==1) {
			int datas=clazzMapper.queryAllClazzCount(cid);
			//有权限
			PageBean page=new PageBean(datas, pagesize,clazzMapper.queryAllClazz((cur-1)*pagesize,pagesize,cid), cur);
			return page;
		}
		int datas=clazzMapper.queryByTidAdminClazzCount(sid,cid);
		//有权限
		PageBean page=new PageBean(datas, pagesize,clazzMapper.queryByTidAdminClazz(sid, (cur-1)*pagesize, pagesize,cid),cur);
		return page;
	}

	@Override
	public List<ZzyGrade> queryAll() {
		// TODO Auto-generated method stub
		return zzyGradeMapper.queryAll();
	}
	
	//发布考试
	public int testPublish(TestPublishParam obj) {
		System.out.println(JSON.toJSONString(obj));
		//添加考试实例
		int i=testinstanceMapper.insertTestInstance(obj.getObj());
		if(i>0) {
			System.out.println("试卷实例添加成功");
			System.out.println(obj.getObj().getId());
			List<TestclassVoParam> list=obj.getClazz();
			System.out.println(JSON.toJSONString(list));
			Integer tid=obj.getObj().getId();		//作业实例id
			for (TestclassVoParam testclassVoParam : list) {
				Integer cid=testclassVoParam.getCid();	//班级id
				Integer roomid=testclassVoParam.getRoomid();			//教室id
				Integer user2=testclassVoParam.getTeachTwo();			//阅卷人id
				Integer user1=testclassVoParam.getTid();					//监考人
				Participatetestclass clazz=new Participatetestclass();
				clazz.setTid(tid);
				clazz.setStatus(0);
				clazz.setCid(cid);
				clazz.setClassroomid(roomid);
				clazz.setUser1(user1.toString());
				clazz.setUser2(user2.toString());
				//考试状态(0已发布,1待批改,2待提交，6已批改)
				clazz.setUser3("0");
				int j=participatetestclassMapper.inserList(clazz);
				if(j>0) {
					System.out.println("考试班级实例添加成功！");
					List<ClazzAndStuParam> stulist=obj.getList();
					for (ClazzAndStuParam stuobj : stulist) {		//所有参考的学生和班级
						if(stuobj.getCid()==cid) {
							Integer[] stus=stuobj.getStus();	
							Map<String, Object> map=new HashMap<String, Object>();
							map.put("stus", stus);
							map.put("tid",tid);
							map.put("clazzid", clazz.getId());
							int result=participateteststuMapper.insertList(map);
							if(result>0) {
								Participatetestclass pobj=new Participatetestclass();
								pobj.setUser3("2");
								pobj.setTid(tid);
								testStatusTaskJob.zzz(pobj);
								dynamicTaskJobs.addTaskJob(testStatusTaskJob,obj.getObj().getStarttime()+":00");
								Participatetestclass pobj2=new Participatetestclass();
								pobj2.setUser3("3");
								pobj2.setTid(tid);
								/*System.out.println(JSON.toJSONString(pobj2));*/
								testStatusTaskJobEnd.zzz(pobj2);
								dynamicTaskJobs.addTaskJob(testStatusTaskJobEnd,obj.getObj().getEndtime()+":00");
								
								//学生考试时间结束没有交卷统一零分处理
								testTimeEndTaskJobs.setObjValue(tid);
								dynamicTaskJobs.addTaskJob(testTimeEndTaskJobs, obj.getObj().getEndtime()+":00");
								System.out.println("学生考试添加成功！");
								return result;
							}
						}
					}
				}
				return 0;
			}
		}
		return 0;
	}

}

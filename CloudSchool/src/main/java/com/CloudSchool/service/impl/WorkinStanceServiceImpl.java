package com.CloudSchool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.ParticipationworkclassMapper;
import com.CloudSchool.dao.ParticipationworkstuMapper;
import com.CloudSchool.dao.WorkinstanceMapper;
import com.CloudSchool.dao.WorkmouldMapper;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Participatetestclass;
import com.CloudSchool.domain.Participationworkclass;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.zjfvo.ClazzAndStuParam;
import com.CloudSchool.domain.zjfvo.PublishWorkInfo;
import com.CloudSchool.domain.zjfvo.WorkPublishParam;
import com.CloudSchool.service.WorkMouldService;
import com.CloudSchool.service.WorkinStanceService;
@Service
@Transactional
public class WorkinStanceServiceImpl implements WorkinStanceService{
	@Autowired
	WorkinstanceMapper workinstanceMapper;
	
	@Autowired
	ParticipationworkclassMapper participationworkclassMapper;
	@Autowired
	ParticipationworkstuMapper participationworkstuMapper;
	
	@Autowired
	WorkmouldMapper workmouldMapper;
	//发布作业
	@Override
	public int publishWork(WorkPublishParam obj) {
		int i=workinstanceMapper.insertSelective(obj.getObj());	//添加作业实例
		if(i>0) {
			List<ClazzAndStuParam> list=obj.getList();
			int count=0;
			for (ClazzAndStuParam item : list) {
				Integer cid=item.getCid();	//班级id	obj
				Integer wid=obj.getObj().getId();	//作业id
				Integer[] stus=item.getStus();		//学生id集合
				Participationworkclass clazz=new Participationworkclass();
				clazz.setCid(cid);
				clazz.setWid(wid);
				int j=participationworkclassMapper.insertObj(clazz);	//添加参加作业班级
				Participatetestclass c;
				if(j>0) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("wid", wid);
					map.put("list",stus);
					map.put("user1",clazz.getId());
					int a=participationworkstuMapper.insertList(map); //添加参加这次作业的学生
					if(a>0) {
						count+=workmouldMapper.updateCountByid(obj.getObj().getWid());	//修改模板使用次数
					}else {
						return 0;
					}
				}else {
					return 0;
				}
			}
			return count;
			
		}
		return 0;
	}
	
	 /*根据教师id查询发布的作业 */
	@Override
	public PageBean queryPublishWorkByTid(Integer tid, Integer wStatus,Integer pageSize,Integer cur) {
		int datas=workinstanceMapper.queryPublishWorkByTidCount(tid, wStatus);	//数量
		List<PublishWorkInfo> list=workinstanceMapper.queryPublishWorkByTid(tid, wStatus,pageSize,(cur-1)*pageSize);
		PageBean page=new PageBean(datas, pageSize, list, cur);
		return page;
	}

	@Override
	public Workinstance queryStudentWork(Integer wid, Integer sid) {
		// TODO Auto-generated method stub
		return workmouldMapper.queryStudentWork(wid, sid);
	}

	@Override
	public Workinstance queryWorkStuInfo(Integer id) {
		// TODO Auto-generated method stub
		return workinstanceMapper.queryWorkStuInfo(id);
	}

}

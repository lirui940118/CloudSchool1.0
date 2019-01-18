package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CloudSchool.dao.WtrecordMapper;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.service.WtrecordService;
import com.alibaba.fastjson.JSON;
@Service
@Transactional
public class WtrecordServiceImpl implements WtrecordService {
	
	@Autowired
	WtrecordMapper wtrecordMapper;
	@Override
	public int pageSaveClose( Workinstance obj) {
		List<TopicWithBLOBs> topicList=obj.getTopicWithBLOBsList();	//所有题目对象
		List<Wtrecord> list=new ArrayList<Wtrecord>();				//题目的所有记录
		wtrecordMapper.deleteBySidAndWid(obj.getId(), obj.getStu().getSid());					//根据学生id和作业id删除记录
		for (TopicWithBLOBs topicWithBLOBs : topicList) {	
			Wtrecord wtrecord=new Wtrecord();
			System.out.println(JSON.toJSONString(topicWithBLOBs));
			if(topicWithBLOBs.getWtrecord()!=null) {
				wtrecord.setWid(topicWithBLOBs.getWtrecord().getWid());
				wtrecord.setSid(topicWithBLOBs.getWtrecord().getSid());
				wtrecord.setTid(topicWithBLOBs.getWtrecord().getTid());
				wtrecord.setType(1);
				/*添加非上机题目记录*/
				if(topicWithBLOBs.getWtrecord().getResult()!=null) {
					wtrecord.setResult(topicWithBLOBs.getWtrecord().getResult());
					System.out.println(topicWithBLOBs.getWtrecord().getResult());
					list.add(wtrecord);	//添加题目记录
					
				}
				/*添加上机题目记录*/
				if(topicWithBLOBs.getWtrecord().getUser1()!=null) {
					wtrecord.setUser1(topicWithBLOBs.getWtrecord().getUser1());
					list.add(wtrecord);	//添加题目记录
				}
			}
			
		}
		return wtrecordMapper.insertWorkRecordList(list);
	}

}

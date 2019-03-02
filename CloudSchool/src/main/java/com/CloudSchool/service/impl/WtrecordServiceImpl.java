package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.CloudSchool.dao.ParticipateteststuMapper;
import com.CloudSchool.dao.ParticipationworkstuMapper;
import com.CloudSchool.dao.TestgradeMapper;
import com.CloudSchool.dao.TestinstanceMapper;
import com.CloudSchool.dao.WorkgradeMapper;
import com.CloudSchool.dao.WorkinstanceMapper;
import com.CloudSchool.dao.WtrecordMapper;
import com.CloudSchool.domain.Participationworkstu;
import com.CloudSchool.domain.Testgrade;
import com.CloudSchool.domain.Testinfo;
import com.CloudSchool.domain.Testinstance;
import com.CloudSchool.domain.TopicWithBLOBs;
import com.CloudSchool.domain.Workgrade;
import com.CloudSchool.domain.Workinstance;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.statistics.BadTopicVO;
import com.CloudSchool.domain.zjfvo.TestInfo;
import com.CloudSchool.service.WtrecordService;
import com.alibaba.fastjson.JSON;
@Service
@Transactional
public class WtrecordServiceImpl implements WtrecordService {
	
	@Autowired
	WtrecordMapper wtrecordMapper;
	@Autowired
	ParticipationworkstuMapper participationworkstuMapper;
	@Autowired
	WorkinstanceMapper workinstanceMapper;
	@Autowired 
	WorkgradeMapper workgradeMapper;
	@Autowired
	TestinstanceMapper testinstanceMapper;
	@Autowired
	ParticipateteststuMapper participateteststuMapper;
	@Autowired
	TestgradeMapper testgradeMapper;
	@Override
	public int pageSaveClose( Workinstance obj) {
		//提交试卷不再删除再保存（提交作业）
		if(obj.getExit()!=null) {
			return 0;
		}
		List<TopicWithBLOBs> topicList=obj.getTopicWithBLOBsList();	//所有题目对象
		List<Wtrecord> list=new ArrayList<Wtrecord>();				//题目的所有记录
		wtrecordMapper.deleteBySidAndWid(obj.getId(), obj.getStu().getSid());				//根据学生id和作业id删除记录
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
	
	/*学生交作业*/
	public int studentPublishWork(Workinstance obj) {
		List<TopicWithBLOBs> topicList=obj.getTopicWithBLOBsList();	//所有题目对象
		List<Wtrecord> list=new ArrayList<Wtrecord>();				//题目的所有记录
		wtrecordMapper.deleteBySidAndWid(obj.getId(), obj.getStu().getSid());				//根据学生id和作业id删除记录
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
					list.add(wtrecord);	//添加题目记录对象
					
				}
				/*添加上机题目记录*/
				if(topicWithBLOBs.getWtrecord().getUser1()!=null) {
					wtrecord.setUser1(topicWithBLOBs.getWtrecord().getUser1());
					list.add(wtrecord);	//添加题目记录对象
				}
			}
			
		}
		
		int result=wtrecordMapper.insertWorkRecordList(list);	//添加题目记录
		if(result>0) {
			List<Wtrecord> wtrecordList=wtrecordMapper.queryByWidAndSidAllSelect(obj.getId(),obj.getStu().getSid());
			for (Wtrecord wtrecord : wtrecordList) {
				/*比对答题结果和正确答案*/
				System.out.println(wtrecord.getResult()+"=="+wtrecord.getObj().getOption());
				if(wtrecord.getResult().equals(wtrecord.getObj().getOption())) {
					int score=wtrecord.getTopic().getUser1();
					int topicid=wtrecord.getId();
					wtrecordMapper.updateScoreById(score, topicid);
				}else {
					int topicid=wtrecord.getId();
					wtrecordMapper.updateScoreById(0, topicid);
				}
			}
			//如果作业类型为选择题类型  直接批改给分  （0待领取 1待提交 2待批改 3已批改）
			if(obj.getWorkmould().getWtype()==0) {
				//修改作业为已批该
				int i=participationworkstuMapper.updateIscorrectByid(3, obj.getId(),obj.getStu().getSid());
				if(i>0) {
					Workgrade workgrade=new Workgrade();	//学生成绩对象
					workgrade.setUid( obj.getStu().getSid());	//学生id
					workgrade.setWid(obj.getId());				//作业id
					int score=wtrecordMapper.queryByWidAndSidSumScore(obj.getId(), obj.getStu().getSid());
					workgrade.setScore(score); 					//得分
					System.out.println(JSON.toJSONString(obj));
					int worksumscore=workinstanceMapper.querySumScoreById(obj.getTopicWithBLOBsList().get(0).getWtrecord().getWid());
					
					//及格
					if(score>=worksumscore*0.9) {
						workgrade.setRank("A");					//评分等级 A B C D
					}else if(score>=worksumscore*0.8 && score<worksumscore*0.9) {
						workgrade.setRank("B");					//评分等级 A B C D
					}else if(score>=worksumscore*0.6 && score<worksumscore*0.8) {
						workgrade.setRank("C");					//评分等级 A B C D
					}else if(score<worksumscore*0.6) {
						workgrade.setRank("D");					//评分等级 A B C D
					}
					return workgradeMapper.inserStuScore(workgrade);
				}
			}
			//根据作业id 修改作业状态为待批改
			int i=participationworkstuMapper.updateIscorrectByid(2, obj.getId(),obj.getStu().getSid());
			if(i>0) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public List<BadTopicVO> queryBadKnowledagePointBySid(Integer sId) {
		return wtrecordMapper.queryBadKnowledagePointBySid(sId);
	}

	@Override
	public Wtrecord queryTopicById(Integer id) {
		// TODO Auto-generated method stub
		return wtrecordMapper.queryTopicById(id);
	}
	
	//手动批改作业
	@Override
	public int updateScoreByWidSidTid(Wtrecord obj) {
		// TODO Auto-generated method stub
		return wtrecordMapper.updateScoreByWidSidTid(obj);
	}
	
	
	//交卷
	public int testPublish(@RequestBody TestInfo obj) {
		List<Testinfo> topiclist=obj.getList();		//题目集合
		Integer testid=obj.getId();					//考试实例id
		List<Wtrecord> list=new ArrayList<Wtrecord>();				//题目的所有记录
		wtrecordMapper.deleteBySidAndWidTest(testid, obj.getSid());
		for (Testinfo testinfo : topiclist) {
			Wtrecord wtrecord=new Wtrecord();
			if(testinfo.getTopicWithBLOBs().getWtrecord()!=null) {
				wtrecord.setWid(testinfo.getTopicWithBLOBs().getWtrecord().getWid());
				wtrecord.setSid(testinfo.getTopicWithBLOBs().getWtrecord().getSid());
				wtrecord.setTid(testinfo.getTopicWithBLOBs().getWtrecord().getTid());
				wtrecord.setType(0);
				/*添加非上机题目记录*/
				if(testinfo.getTopicWithBLOBs().getWtrecord().getResult()!=null) {
					wtrecord.setResult(testinfo.getTopicWithBLOBs().getWtrecord().getResult());
					list.add(wtrecord);	//添加题目记录对象
					
				}
				/*添加上机题目记录*/
				if(testinfo.getTopicWithBLOBs().getWtrecord().getUser1()!=null) {
					wtrecord.setUser1(testinfo.getTopicWithBLOBs().getWtrecord().getUser1());
					list.add(wtrecord);	//添加题目记录对象
				}
			}
		}
		int result=wtrecordMapper.insertWorkRecordList(list);	//添加题目记录
		Integer testcount=testinstanceMapper.queryTestTopicCount(testid);	//试卷题目总数量
		Integer typeCount=testinstanceMapper.queryByTypeCount(1, testid);	//选择题总数量
		if(result>0) {
			List<Wtrecord> wtrecordList=wtrecordMapper.queryByWidAndSidAllSelect(obj.getId(),obj.getSid());
			for (Wtrecord wtrecord : wtrecordList) {
				/*比对答题结果和正确答案*/
				System.out.println(wtrecord.getResult()+"=="+wtrecord.getObj().getOption());
				if(wtrecord.getResult().equals(wtrecord.getObj().getOption())) {
					int score=wtrecord.getTopic().getUser1();
					int topicid=wtrecord.getId();
					wtrecordMapper.updateScoreById(score, topicid);
				}else {
					int topicid=wtrecord.getId();
					wtrecordMapper.updateScoreById(0, topicid);
				}
			}
			
			if(testcount==typeCount) {
				//试卷全部为选择题
				int i=participateteststuMapper.updateStatusById(3,obj.getSid(),obj.getId());
				if(i>0) {
					Testgrade gradeobj=new Testgrade();
					gradeobj.setSid(obj.getSid());
					gradeobj.setTid(obj.getId());
					Integer testscore=wtrecordMapper.queryByWidAndSidSumScoreTest(obj.getId(), obj.getSid());
					if(testscore==null) {
						testscore=0;
					}
					gradeobj.setScore(testscore);
					return testgradeMapper.insertObj(gradeobj);
				}
			}
			//修改考试状态为待批改
			int count=participateteststuMapper.updateStatusById(2,obj.getSid(),obj.getId());
			if(count>0) {
				return count;
			}
		}
		return result;
	}

}


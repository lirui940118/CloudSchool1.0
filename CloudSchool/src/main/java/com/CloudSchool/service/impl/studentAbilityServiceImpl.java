package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.domain.LrConfigrate;
import com.CloudSchool.domain.Workgrade;
import com.CloudSchool.service.GkKaoQinService;
import com.CloudSchool.service.GkWjcsjfService;
import com.CloudSchool.service.LrConfigrateService;
import com.CloudSchool.service.TopicService;
import com.CloudSchool.service.WorkgradeService;
import com.CloudSchool.service.ZzyRealtimeClassroomService;
import com.CloudSchool.service.studentAbilityService;
@Service
public class studentAbilityServiceImpl implements studentAbilityService{

	
	@Autowired
	TopicService topicService;
	@Autowired 
	GkKaoQinService gkKaoQinService;
	@Autowired
	GkWjcsjfService gkWjcsjfService;
	@Autowired
	LrConfigrateService lrConfigrateService;
	@Autowired
	ZzyRealtimeClassroomService zzyRealtimeClassroomService;
	@Autowired
	WorkgradeService workgradeService;
	
	@Override
	public List<Integer> queryStudentAbility(Integer sId, Integer gId) {
		List<Integer> list = new ArrayList<Integer>();
		//===================参数=====================
		LrConfigrate lrConfigrate = lrConfigrateService.queryAllConfig();
		
		//===================理解能力=====================
		//实际刷题数量rate 考点类型(1.理解)
		Integer realTotolTopicRate1 = topicService.queryRealTopicRateBysIdAndgId(sId, gId,1);
		//答题正确率 29 = 29%
		Integer topicAccuracy1 = topicService.queryCurrentTotalTopicAccuracyBysIdAndgId(sId, gId,1);
		//教员对学员理解能力主观评分 1理解能力
		Integer assess1 = gkWjcsjfService.queryAbilitWjBysIdAndgId(sId, gId,1);//tid
		
		//计算理解能力
		Double score1= 0d;
		score1 = realTotolTopicRate1 *lrConfigrate.getConfig1() /100
				+ topicAccuracy1 * lrConfigrate.getConfig2() /100
				+ assess1 * lrConfigrate.getConfig3() /100;
		
		list.add((int) Math.round(score1));
		
		
		//===================识记能力=====================
		//实际答题量rate 考点类型(0.识记)
		Integer realTotolTopicRate0 = topicService.queryRealTopicRateBysIdAndgId(sId, gId,0);
		//答题正确率 29 = 29%
		Integer topicAccuracy0 = topicService.queryCurrentTotalTopicAccuracyBysIdAndgId(sId, gId,0);
		//教员对学员理解能力主观评分 2识记能力
		Integer assess2 = gkWjcsjfService.queryAbilitWjBysIdAndgId(sId, gId,2);//tid
		
		//计算识记能力
		Double score2 = 0d;
		score2 = realTotolTopicRate0 * lrConfigrate.getConfig4() /100 
				+ topicAccuracy0 * lrConfigrate.getConfig5() /100
				+ assess2 * lrConfigrate.getConfig6() /100;
		 
		
		list.add((int) Math.round(score2));
		
		
		
		
		//=======================自控力===================
		//到勤率 40.4 = 40.4%
		Double gaoqinRate = gkKaoQinService.querykaoqinRateBygIdAndsId(sId, gId);
		//学员作业及时完成率
		Double workTimelyFinishRate = workgradeService.queryStudentWorkTimelyFinishRate(sId, gId);
		//教员对学员理解能力主观评分 3自控力能力
		Integer assess3 = gkWjcsjfService.queryAbilitWjBysIdAndgId(sId, gId,3);//tid
		
		//计算自控力能力todo 作业完成及时率
		Double score3 = gaoqinRate * lrConfigrate.getConfig7() /100 
				+ workTimelyFinishRate * lrConfigrate.getConfig8() /100
				+ assess3 * lrConfigrate.getConfig9() /100;
		
		list.add((int) Math.round(score3));
		
		
		
		//=======================应用能力===================
		//应用题目实际答题量rate 考点类型(2.应用)
		Integer applicationAbilityRate = topicService.queryCurrentTotalTopicAccuracyBysIdAndgId(sId, gId,2);
		//教员对学员理解能力主观评分 4动手能力
		Integer assess4 = gkWjcsjfService.queryAbilitWjBysIdAndgId(sId, gId,4);//tid
		//计算应用能力
		Double score4  = applicationAbilityRate * lrConfigrate.getConfig10() /100
				+ assess4 * lrConfigrate.getConfig11() /100;
		
		list.add((int) Math.round(score4));
		
		
		//=======================课堂表现===================
		Integer RealtimeScore = zzyRealtimeClassroomService.queryRealtimeBysIdAndgId(sId, gId);
		
		//教员对学员理解能力主观评分 5课堂表现
		Integer assess5 = gkWjcsjfService.queryAbilitWjBysIdAndgId(sId, gId,5);//tid
		//计算课堂表现
		Double score5  = RealtimeScore * lrConfigrate.getConfig12() /100
				+ assess5 * lrConfigrate.getConfig13() /100;
		
		list.add((int) Math.round(score5));
		
		return list;
	}

}

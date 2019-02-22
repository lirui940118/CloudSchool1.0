package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CqjStaffMapper;
import com.CloudSchool.dao.GkWjcsjfMapper;
import com.CloudSchool.dao.LrConfigrateMapper;
import com.CloudSchool.dao.LrStaffAbilityMapper;
import com.CloudSchool.domain.LrConfigrate;
import com.CloudSchool.domain.statistics.StaffBaseVO;
import com.CloudSchool.service.CqjStaffService;
import com.CloudSchool.service.GkKaoQinService;
import com.CloudSchool.service.GkWjcsjfService;
@Service
public class CqjStaffServiceImpl implements CqjStaffService{

	@Autowired
	CqjStaffMapper cqjStaffMapper;
	@Autowired 
	LrStaffAbilityMapper lrStaffAbilityMapper;
	@Autowired
	LrConfigrateMapper lrConfigrateMapper;
	@Autowired 
	GkWjcsjfService gkWjcsjfService;
	@Autowired
	GkKaoQinService gkKaoQinService;
	
	@Override
	public StaffBaseVO queryStaffBaseVOBySid(Integer staffId) {
		return cqjStaffMapper.queryStaffBaseVOBySid(staffId);
	}


	@Override
	public List<Integer> queryStaffAbility(Integer staffId) {
		List<Integer> list = new ArrayList<Integer>();
		//参数系数
		LrConfigrate lrConfigrate = lrConfigrateMapper.queryAllConfig();
		//查询员工职位id  5为教员 6为班主任
		//判断是教员还是班主任（算法不一致）
		Integer positionId = cqjStaffMapper.queryPositionIdByStaffId(staffId);
		Integer tip = null;//标识教员和班主任 0教员 1为班主任
		if(positionId.equals(5)) 
			tip = 0;
		else if(positionId.equals(6))
			tip = 1;
		System.out.println("tip="+tip+"(如果为null 职称查询错误！)");
		//===================升学率和毕业率===================
		Double upRateScore = lrStaffAbilityMapper.getUpRateByStaffId(staffId, tip) ;
		Double workRateScore = lrStaffAbilityMapper.getUpRateByStaffId(staffId, tip);
		
		Integer upAndWorkRateScore = (int)Math.round(upRateScore * lrConfigrate.getConfig14()/100
				+ workRateScore *lrConfigrate.getConfig15()/100) ;
		if(upRateScore == -1 || workRateScore == -1)
			System.out.println("学员能力-员工没有带过班级!");
		list.add(upAndWorkRateScore);
		//===================教学质量===================
		Integer TeachingQualityScore = 0;
		if(tip == 0) {//教员
			//学员做题数量
			Double studentCountScore = lrStaffAbilityMapper.getStudentRealTopicCountRateByStaffId(staffId);
			//学员做题正确率
			Double studentRightScore = lrStaffAbilityMapper.getStudentRightTopicRateByStaffId(staffId);
			//学员对教员的评价
			Integer wjScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId,6);//tid 教员和班主任教学质量
			TeachingQualityScore = (int)Math.round(studentCountScore * lrConfigrate.getConfig16() / 100
					+ studentRightScore * lrConfigrate.getConfig17() / 100
					+ wjScore * lrConfigrate.getConfig18() / 100);
		}else if(tip == 1) {//班主任
			//学员对班主任的评价
			TeachingQualityScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 6);//教员和班主任教学质量
		}else {
			System.out.println("tip空值");
			return null;
		}
		list.add(TeachingQualityScore);
		//===================责任心===================
		Integer dutyScore = 0;
		if(tip == 0) {//教员
			//平均布置作业次数
			int standardWorkCount = (int)Math.round(lrConfigrate.getConfig19());
			Double averageWorkCountScore = lrStaffAbilityMapper.getWorkCountReteByStaffId(staffId,standardWorkCount);
			//平均布置考试次数
			int standardTestCount = (int)Math.round(lrConfigrate.getConfig20());
			Double averageTestCountScore = lrStaffAbilityMapper.getTestCountReteByStaffId(staffId,standardTestCount);
			//考勤率
			Double kaoqinRateScore = gkKaoQinService.querykaoqinRateByStaffId(staffId);
			//问卷调查（学生反馈）
			Integer wjScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 7);//教员责任心7
			
			dutyScore = (int)Math.round(averageWorkCountScore * lrConfigrate.getConfig21() / 100
					+ averageTestCountScore * lrConfigrate.getConfig22() / 100
					+ kaoqinRateScore * lrConfigrate.getConfig23() / 100
					+ wjScore * lrConfigrate.getConfig24());
		}else if(tip == 1) {//班主任
			//谈心（访谈） 覆盖率（广度rate）
			Double TalkRateScore = lrStaffAbilityMapper.getTalkRateByStaffId(staffId);
			//谈心（访谈） 基本次数（深度count）
			Integer talkStandarCount = (int)Math.round(lrConfigrate.getConfig25());
			Double TalkCountScore = lrStaffAbilityMapper.getTalkCountRateByStaffId(staffId, talkStandarCount);
			//考勤率
			Double kaoqinRateScore = gkKaoQinService.querykaoqinRateByStaffId(staffId);
			//问卷调查（学生反馈）
			Integer wjScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 8);//班主任责任心8
			
			dutyScore = (int)Math.round(TalkRateScore * lrConfigrate.getConfig26() / 100
					+ TalkCountScore * lrConfigrate.getConfig27() / 100
					+ kaoqinRateScore * lrConfigrate.getConfig28() / 100
					+ wjScore * lrConfigrate.getConfig29() / 100);
		}
		list.add(dutyScore);
		return list;
	}


	@Override
	public Integer queryPositionIdByStaffId(Integer staffId) {
		return cqjStaffMapper.queryPositionIdByStaffId(staffId);
	}

}

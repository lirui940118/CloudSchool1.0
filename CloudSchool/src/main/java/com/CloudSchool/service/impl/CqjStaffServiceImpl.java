package com.CloudSchool.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CqjStaffMapper;
import com.CloudSchool.dao.CqjUserMapper;
import com.CloudSchool.dao.GkWjcsjfMapper;
import com.CloudSchool.dao.LrConfigrateMapper;
import com.CloudSchool.dao.LrStaffAbilityMapper;
import com.CloudSchool.dao.ZzyClassScheduleMapper;
import com.CloudSchool.domain.CqjStaff;
import com.CloudSchool.domain.LrConfigrate;
import com.CloudSchool.domain.statistics.StaffBaseVO;
import com.CloudSchool.service.CqjStaffService;
import com.CloudSchool.service.CqjUserService;
import com.CloudSchool.service.GkKaoQinService;
import com.CloudSchool.service.GkWjcsjfService;
import com.alibaba.fastjson.JSON;

@Service
public class CqjStaffServiceImpl implements CqjStaffService {

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
	@Autowired
	ZzyClassScheduleMapper zzyClassScheduleMapper;
	@Autowired
	CqjUserMapper cum; 
	@Override
	public StaffBaseVO queryStaffBaseVOBySid(Integer staffId) {
		return cqjStaffMapper.queryStaffBaseVOBySid(staffId);
	}

	@Override
	public List<Integer> queryStaffAbility(Integer staffId) {
		List<Integer> list = new ArrayList<Integer>();
		// 参数系数
		LrConfigrate lrConfigrate = lrConfigrateMapper.queryAllConfig();
		// 查询员工职位id 5为教员 6为班主任
		// 判断是教员还是班主任（算法不一致）
		Integer positionId = cqjStaffMapper.queryPositionIdByStaffId(staffId);
		Integer tip = null;// 标识教员和班主任 0教员 1为班主任
		if (positionId.equals(5))
			tip = 0;
		else if (positionId.equals(6))
			tip = 1;
		System.out.println("tip=" + tip + "(如果为null 职称查询错误！)");
		// ===================升学率和毕业率===================
		Double upRateScore = lrStaffAbilityMapper.getUpRateByStaffId(staffId, tip);
		Double workRateScore = lrStaffAbilityMapper.getUpRateByStaffId(staffId, tip);

		Integer upAndWorkRateScore = (int) Math.round(
				upRateScore * lrConfigrate.getConfig14() / 100 + workRateScore * lrConfigrate.getConfig15() / 100);
		if (upRateScore == -1 || workRateScore == -1)
			System.out.println("学员能力-员工没有带过班级!");
		list.add(upAndWorkRateScore);
		// ===================教学质量===================
		Integer TeachingQualityScore = 0;
		if (tip == 0) {// 教员
			// 学员做题数量
			Double studentCountScore = lrStaffAbilityMapper.getStudentRealTopicCountRateByStaffId(staffId);
			// 学员做题正确率
			Double studentRightScore = lrStaffAbilityMapper.getStudentRightTopicRateByStaffId(staffId);
			// 学员对教员的评价
			Integer wjScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 6);// tid 教员和班主任教学质量
			TeachingQualityScore = (int) Math.round(studentCountScore * lrConfigrate.getConfig16() / 100
					+ studentRightScore * lrConfigrate.getConfig17() / 100
					+ wjScore * lrConfigrate.getConfig18() / 100);
		} else if (tip == 1) {// 班主任
			// 学员对班主任的评价
			TeachingQualityScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 6);// 教员和班主任教学质量
		} else {
			System.out.println("tip空值");
			return null;
		}
		list.add(TeachingQualityScore);
		// ===================责任心===================
		Integer dutyScore = 0;
		if (tip == 0) {// 教员
			// 平均布置作业次数
			int standardWorkCount = (int) Math.round(lrConfigrate.getConfig19());
			Double averageWorkCountScore = lrStaffAbilityMapper.getWorkCountReteByStaffId(staffId, standardWorkCount);
			// 平均布置考试次数
			int standardTestCount = (int) Math.round(lrConfigrate.getConfig20());
			Double averageTestCountScore = lrStaffAbilityMapper.getTestCountReteByStaffId(staffId, standardTestCount);
			// 考勤率
			Double kaoqinRateScore = gkKaoQinService.querykaoqinRateByStaffId(staffId);
			// 问卷调查（学生反馈）
			Integer wjScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 7);// 教员责任心7

			dutyScore = (int) Math.round(averageWorkCountScore * lrConfigrate.getConfig21() / 100
					+ averageTestCountScore * lrConfigrate.getConfig22() / 100
					+ kaoqinRateScore * lrConfigrate.getConfig23() / 100 + wjScore * lrConfigrate.getConfig24()/100);
		} else if (tip == 1) {// 班主任
			// 谈心（访谈） 覆盖率（广度rate）
			Double TalkRateScore = lrStaffAbilityMapper.getTalkRateByStaffId(staffId);
			// 谈心（访谈） 基本次数（深度count）
			Integer talkStandarCount = (int) Math.round(lrConfigrate.getConfig25());
			Double TalkCountScore = lrStaffAbilityMapper.getTalkCountRateByStaffId(staffId, talkStandarCount);
			// 考勤率
			Double kaoqinRateScore = gkKaoQinService.querykaoqinRateByStaffId(staffId);
			// 问卷调查（学生反馈）
			Integer wjScore = gkWjcsjfService.queryAbilitWjByStaffId(staffId, 8);// 班主任责任心8

			dutyScore = (int) Math.round(TalkRateScore * lrConfigrate.getConfig26() / 100
					+ TalkCountScore * lrConfigrate.getConfig27() / 100
					+ kaoqinRateScore * lrConfigrate.getConfig28() / 100 + wjScore * lrConfigrate.getConfig29() / 100);
		}
		list.add(dutyScore);
		return list;
	}

	@Override
	public Integer queryPositionIdByStaffId(Integer staffId) {
		return cqjStaffMapper.queryPositionIdByStaffId(staffId);
	}

	// 查询一个时间段 所有有空的任课老师（赵举峰）
	@Override
	public List<CqjStaff> queryNullTeach(String time, Integer status) {
		List<CqjStaff> teachs = cqjStaffMapper.queryTeachAll();// 所有任课老师
		System.out.println(JSON.toJSONString(teachs));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<CqjStaff> list = new ArrayList<CqjStaff>(); // 有空的所有老师
		try {
			Date date = formatter.parse(time);
			// status 0表示上午 1标识下午 2表示全天
			if (status != 2) {
				for (CqjStaff obj : teachs) {
					// 当前的这个老师这一天status是否有课
					int count = zzyClassScheduleMapper.queryByyoukong(obj.getStaffid(), date, status);
					if (count > 0) {
						// 没空占用了
						continue;
					}
					// 有空
					System.out.println("老师有空！");
					list.add(obj);
				}
			} else {
				// 全天
				for (CqjStaff obj : teachs) {
					// 当前的这个老师这一天status是否有课
					Integer count = zzyClassScheduleMapper.queryBytimeTeach(obj.getStaffid(), date);
					if (count > 0) {
						// 没空
						continue;
					}
					// 有空
					System.out.println("老师全天有空");
					list.add(obj);
				}
			}
			return list;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int addStaffs(List<CqjStaff> staff) {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();
		// 取出当前的年，月，日
		int year = calendar.get(calendar.YEAR);

		// 月的数值加1，使之变成习惯的月份大小（1～12月）
		int month = calendar.get(calendar.MONTH) + 1;
		int today = calendar.get(calendar.DAY_OF_MONTH);

		String newmonth = month < 10?"0" + month:month + "";
		String newtoday = today < 10?"0" + today:today + "";
		//String staffnub = year + "" + newmonth + newtoday;
		//System.out.println(staffnub);
		String timeNub=cqjStaffMapper.getTimeNum();
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("list", staff);
		Long staffnub=null;
		if(timeNub!=null) {
			staffnub=Long.parseLong(timeNub)+1;
		}else {
			staffnub=Long.parseLong(year + "" + newmonth + newtoday+"0001");
		}
		for (CqjStaff s : staff) {
			if(s!=null) {
				s.setStaffnub(staffnub+"");
				staffnub++;
			}
		}
		cqjStaffMapper.addStaffs(staff);
		return cum.addStaffUser(staff);
	}
	@Override
	public List<CqjStaff> ZzyqueryTeachAll() {
		// TODO Auto-generated method stub
		return cqjStaffMapper.ZzyqueryTeachAll();
	}


	@Override
	public List<CqjStaff> ZzyqueryXinTeach() {
		// TODO Auto-generated method stub
		return cqjStaffMapper.ZzyqueryXinTeach();
	}


	@Override
	public Integer ZzyUpdateUser(Integer staffid) {
		// TODO Auto-generated method stub
		return cqjStaffMapper.ZzyUpdateUser(staffid);
	}

	@Override
	public List<CqjStaff> queryAllYuanGong() {
		// TODO Auto-generated method stub
		return cqjStaffMapper.queryAllYuanGong();
	}

}

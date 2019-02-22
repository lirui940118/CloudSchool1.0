package com.CloudSchool.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudSchool.dao.CqjStaffMapper;
import com.CloudSchool.dao.LrStaffAbilityMapper;
import com.CloudSchool.dao.ZzyCourseMapper;
import com.CloudSchool.dao.ZzySectionMapper;
import com.CloudSchool.domain.ZzyCourse;
import com.CloudSchool.domain.statistics.CourseVO;
import com.CloudSchool.domain.statistics.StaffVO;
import com.CloudSchool.service.CqjStaffService;
import com.CloudSchool.service.ZzyCourseService;

@Service
public class ZzyCourseServiceimpl implements ZzyCourseService{
	
	@Autowired
	ZzyCourseMapper cous;

	@Autowired
	ZzySectionMapper secs;
	
	@Autowired
	LrStaffAbilityMapper lrStaffAbilityMapper;
	@Autowired
	CqjStaffMapper cqjStaffMapper;
	@Autowired
	CqjStaffService cqjStaffService;
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
		// TODO （可以优化） 开办选老师
		
		
		//======================教员========================
		List<CourseVO> courseVOList = new ArrayList<CourseVO>();//最终结果集合
		//选出课程教员
		List<CourseVO> list = lrStaffAbilityMapper.queryStaffAboutOPenStaffBygIdAndmId(gId, mId);
		//计算教员分数出分数 （可以优化TODO）
		for(int i = 0;i<list.size();i++) {
			for(int j = 0;j<list.get(i).getStaffVOList().size();j++) {
				Integer staffId = list.get(i).getStaffVOList().get(j).getStaffId();
				Integer courseId = list.get(i).getCourseId();
				Integer score = lrStaffAbilityMapper.getStaffScoreAboutOpenCLazzByStaffIdAndCourseId(staffId, courseId);
				list.get(i).getStaffVOList().get(j).setStaffScore(score);
			}
			Collections.sort(list.get(i).getStaffVOList());
		}
		
		
		//======================班主任========================
		CourseVO CourseVO = new CourseVO();
		CourseVO.setCourseId(-1);//班主任特殊课程id
		//设置班主任集合
		List<StaffVO> staffVOList = cqjStaffMapper.queryALlMaster();
		//获取班主任得分 （可以优化TODO）
		for(int i = 0;i<staffVOList.size();i++) {
			Integer staffId = staffVOList.get(i).getStaffId();
			List<Integer> MasterAbilityScoreList= cqjStaffService.queryStaffAbility(staffId);
			Integer totalScore = 0;//初始化分数
			for(int j = 0;j<MasterAbilityScoreList.size();j++) {
				totalScore+=MasterAbilityScoreList.get(j);
			}
			staffVOList.get(i).setStaffScore(Math.round(totalScore/3));
		}
		Collections.sort(staffVOList);
		CourseVO.setStaffVOList(staffVOList);
		
		
		//将班主任添加到首位
		courseVOList.add(CourseVO);//班主任添加
		courseVOList.addAll(list);//教员集合
		
		
		return courseVOList;
		//默认第一个为班主任
	}
	public ZzyCourse queryBycid(Integer cid) {
		// TODO Auto-generated method stub
		return cous.queryBycid(cid);
	}
	
}

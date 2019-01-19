package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.Classroom;
import com.CloudSchool.domain.Classtype;
import com.CloudSchool.domain.Commission;
import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Missionhistory;
import com.CloudSchool.domain.ZzyGrade;
import com.CloudSchool.service.ClassroomService;
import com.CloudSchool.service.ClasstypeService;
import com.CloudSchool.service.CommissionService;
import com.CloudSchool.service.MissionHistoryService;
import com.CloudSchool.service.ZzyGradeService;

@Controller
@RequestMapping("/mission")
public class MissionController {
	@Autowired
	ClassroomService cls;
	@Autowired
	ClasstypeService clt;
	@Autowired
	CommissionService com;
	@Autowired
	MissionHistoryService miss;
	@Autowired
	ZzyGradeService gras;

	@RequestMapping("/queryMissionhistory")
	public String queryMissionhistory(Model model,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		user.getUsertypeid();
		user.getPositionid();
		Integer rid=3;
		List<Missionhistory> list=miss.query(rid);
		model.addAttribute("list", list);
		return "czw_mission/missionhistory";
	}
	@RequestMapping("/queryClr")
	public String aaa(Model model) {
		List<Classroom> list=cls.query();
		model.addAttribute("list", list);
		return "czw_mission/ClassRoom";
	}
	@RequestMapping("/toInsertClr")
	public String bbb(Model model) {
		List<Classtype> list=clt.query();
		model.addAttribute("list", list);
		return "czw_mission/insertClassroom";
	}
	@RequestMapping("/addClassRoom")
	@ResponseBody
	public String addClassRoom(Classroom classroom) {
		int i=cls.insertSelective(classroom);
		if(i>0) {
			System.out.println("成功！");
		}
		return "新增成功！";
	}
	@RequestMapping("/delClassRoom")
	public String delClassRoom(Integer id) {
		int i=cls.delete(id);
		if(i>0) {
			System.out.println("成功！");
		}
		return "删除成功！";
	}
	@RequestMapping("/selectByid")
	public String selectByid(Integer id,Model model) {
		Classroom cs=cls.selectByid(id);
		model.addAttribute("cs", cs);
		List<Classtype> list=clt.query();
		model.addAttribute("list", list);
		return "czw_mission/updateClassroom";
	}
	@RequestMapping("/updateClassRoom")
	@ResponseBody
	public String updateClassRoom(Classroom classroom) {
		int i=cls.update(classroom);
		if(i>0) {
			System.out.println("成功！");
		}
		return "修改成功！";
	}
	@RequestMapping("/toCommission")
	public String toCommission(Model model) {
		List<Commission> list=com.query();
		model.addAttribute("list", list);
		return "czw_mission/commission";
	}
	
	@RequestMapping("/toStudentmission")
	public String toStudentmission(Model model) {
		List<ZzyGrade> list=gras.queryAll();
		model.addAttribute("list", list);
		return "czw_mission/publishstumission";
	}
}

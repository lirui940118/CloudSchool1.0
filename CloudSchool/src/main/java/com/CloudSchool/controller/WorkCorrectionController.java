package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.PageBean;
import com.CloudSchool.domain.Participationworkclass;
import com.CloudSchool.domain.Wtrecord;
import com.CloudSchool.domain.zjfvo.StuWorkInfo;
import com.CloudSchool.domain.zjfvo.StudentWork;
import com.CloudSchool.domain.zjfvo.WorkinstanceInfo;
import com.CloudSchool.service.ParticipationworkclassService;
import com.CloudSchool.service.ParticipationworkstuService;
import com.CloudSchool.service.WorkinStanceService;
import com.CloudSchool.service.WtrecordService;

@Controller
@RequestMapping("WorkCorrection")
public class WorkCorrectionController {
	@Autowired
	WorkinStanceService workinStanceService;
	
	@Autowired
	ParticipationworkstuService participationworkstuService;
	
	@Autowired
	WtrecordService wtrecordService;
	
	@Autowired
	ParticipationworkclassService participationworkclassService;
	/*跳转到作业批改*/
	@RequestMapping("toWorkCorrectionIndex")
	public String toWorkCorrectionIndex() {
		return "zjf/workCorrectInfo";
	}
	
	/*根据教师id查询发布的作业 */
	@RequestMapping("queryPublishWorkByTid")
	@ResponseBody
	public PageBean queryPublishWorkByTid(Integer tid, Integer wStatus,Integer pageSize,Integer cur,HttpSession session) {
		CqjUser user=(CqjUser)session.getAttribute("user");
		tid=user.getUsertypeid();
		if(pageSize==null) {
			pageSize=2;
		}
		return workinStanceService.queryPublishWorkByTid(tid, wStatus, pageSize, cur);
	}
	
	
	@RequestMapping("toWorkCorrect")
	public String toWorkCorrect(Integer cid,Integer wid,HttpSession session) {
		session.setAttribute("workCorrectWid",wid);
		session.setAttribute("workCorrectCid",cid);
		return "zjf/WorkCorrect";
	}
	@RequestMapping("queryByCidAndWidShowInfo")
	@ResponseBody
	public List<WorkinstanceInfo> queryByCidAndWidShowInfo(HttpSession session){
		Integer cid=(Integer)session.getAttribute("workCorrectCid");
		Integer wid=(Integer)session.getAttribute("workCorrectWid");
		session.removeAttribute("workCorrectCid");
		session.removeAttribute("workCorrectWid");
		return participationworkstuService.queryByCidAndWidShowInfo(cid,wid);
	}
	
	//作业批改  根据作业id和学生id查询作业 (进行批改)
	@RequestMapping("StuWorkInfo")
	@ResponseBody
	public PageBean queryStuWorkInfo(Integer wid,Integer sid,Integer cur,Integer pagesize){
		if(pagesize==null) {
			pagesize=2;
		}
		return participationworkstuService.queryStuWorkInfo(wid, sid, cur, pagesize);
	}
	
	//作业批改选中题目查出题目记录和详情
	@RequestMapping("queryTopicById")
	@ResponseBody
	public Wtrecord queryTopicById(Integer id) {
		return wtrecordService.queryTopicById(id);
	}
	
	//手动批改作业  给一道题评分
	@RequestMapping("updateScoreByWidSidTid")
	@ResponseBody
	public int updateScoreByWidSidTid(Wtrecord obj) {
		System.out.println("");
		return wtrecordService.updateScoreByWidSidTid(obj);
	}
	
	
	//批改完成后修改学生的本次作业为 已经批改状态
	@RequestMapping("updateIscorrectByid")
	@ResponseBody
	public int updateIscorrectByid(Wtrecord obj) {
		return participationworkstuService.updateIscorrectByid(obj);
	}
	
	
	//修改本次作业状态(作业公布)
	@RequestMapping("updateStatusById")
	@ResponseBody
	public int updateStatusById(Participationworkclass obj) {
		return participationworkclassService.updateStatusById(obj);
	}
	
	//跳转到我的作业历史
	@RequestMapping("toStuworkCorrectInfo")
	public String toStuworkCorrectInfo() {
		return "zjf/student/StuworkCorrectInfo";
	}
	
	@RequestMapping("queryStuWorkBySid")
	@ResponseBody
	public PageBean queryStuWorkBySid(Integer cur,Integer pagesize,Integer isCorrect,HttpSession session){
		if(pagesize==null) {
			pagesize=1;
		}
		CqjUser user=(CqjUser)session.getAttribute("user");
		Integer sid=user.getUsertypeid();
		return participationworkstuService.queryStuWorkBySid(sid,cur,pagesize,isCorrect);
	}
	
	

}

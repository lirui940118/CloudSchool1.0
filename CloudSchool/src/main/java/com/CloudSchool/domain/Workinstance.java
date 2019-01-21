package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

public class Workinstance {
	private Integer id;

	private Integer wid;

	private String starttime;

	private String endtime;

	private String message;

	private Integer tid;

	private String time;

	private Integer status;

	private String user1;

	private String user2;

	private String user3;

	private String user4;

	private String user5;
	/* 题目 */
	private List<TopicWithBLOBs> topicWithBLOBsList;
	/* 模板 */
	private Workmould workmould;
	/* 教员 */
	/*参加作业学生*/
	private Participationworkstu stu;
	
	//参加本次作业实例的所有学生
	private List<Participationworkstu> listStu;
	



	public List<Participationworkstu> getListStu() {
		return listStu;
	}



	public void setListStu(List<Participationworkstu> listStu) {
		this.listStu = listStu;
	}



	public Participationworkstu getStu() {
		return stu;
	}



	public void setStu(Participationworkstu stu) {
		this.stu = stu;
	}

	private CqjStaff staff;
	private Integer tcount;
	private Integer score;
	private Integer exit;
	



	public Integer getExit() {
		return exit;
	}



	public void setExit(Integer exit) {
		this.exit = exit;
	}



	public Integer getTcount() {
		return tcount;
	}



	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}



	public Workmould getWorkmould() {
		return workmould;
	}

	

	public List<TopicWithBLOBs> getTopicWithBLOBsList() {
		return topicWithBLOBsList;
	}



	public void setTopicWithBLOBsList(List<TopicWithBLOBs> topicWithBLOBsList) {
		this.topicWithBLOBsList = topicWithBLOBsList;
	}



	public void setWorkmould(Workmould workmould) {
		this.workmould = workmould;
	}

	public CqjStaff getStaff() {
		return staff;
	}

	public void setStaff(CqjStaff staff) {
		this.staff = staff;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	public String getUser3() {
		return user3;
	}

	public void setUser3(String user3) {
		this.user3 = user3;
	}

	public String getUser4() {
		return user4;
	}

	public void setUser4(String user4) {
		this.user4 = user4;
	}

	public String getUser5() {
		return user5;
	}

	public void setUser5(String user5) {
		this.user5 = user5;
	}
}
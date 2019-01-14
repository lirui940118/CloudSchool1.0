package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

public class ZzyGrade {
    private Integer gid;

    private String gradeName;

    private Integer vid;

    private Integer majorbool;

    private Integer classbool;

    private Date creatTime;

    private Date modificationtime;

    private Integer state;

    private Integer uid;

    private String remark;

    private String user1;

    private String user2;

    private String user3;

    private String user4;

    private String user5;
    
    //年纪下面的班级集合
    private List<Clazz> list;
    
    //年级下面的课程集合
    private List<ZzyCourse> list2;
    

    public List<ZzyCourse> getList2() {
		return list2;
	}

	public void setList2(List<ZzyCourse> list2) {
		this.list2 = list2;
	}

	public List<Clazz> getList() {
		return list;
	}

	public void setList(List<Clazz> list) {
		this.list = list;
	}

	public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getMajorbool() {
        return majorbool;
    }

    public void setMajorbool(Integer majorbool) {
        this.majorbool = majorbool;
    }

    public Integer getClassbool() {
        return classbool;
    }

    public void setClassbool(Integer classbool) {
        this.classbool = classbool;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getModificationtime() {
        return modificationtime;
    }

    public void setModificationtime(Date modificationtime) {
        this.modificationtime = modificationtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
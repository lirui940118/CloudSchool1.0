package com.CloudSchool.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ZzyClassSchedule {
    private Integer csid;

    private Integer clid;

    private Integer rid;

    private Integer tid;

    private Integer cid;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private String time;

    private Integer temporalInterva;

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
    
    //课表中的班级对象
    private Clazz cla;
    //课表中的教室对象
    private Classroom claroom;
    //课表中的教员对象
    private CqjStaff cqjstaff;
    //课表中的课程对象
    private ZzyCourse zzycourse;
    //课表中的事件对象
    private ZzyCourseEvents courseevents;
    

    public ZzyCourseEvents getCourseevents() {
		return courseevents;
	}

	public void setCourseevents(ZzyCourseEvents courseevents) {
		this.courseevents = courseevents;
	}

	public Clazz getCla() {
		return cla;
	}

	public void setCla(Clazz cla) {
		this.cla = cla;
	}

	public Classroom getClaroom() {
		return claroom;
	}

	public void setClaroom(Classroom claroom) {
		this.claroom = claroom;
	}

	public CqjStaff getCqjstaff() {
		return cqjstaff;
	}

	public void setCqjstaff(CqjStaff cqjstaff) {
		this.cqjstaff = cqjstaff;
	}

	public ZzyCourse getZzycourse() {
		return zzycourse;
	}

	public void setZzycourse(ZzyCourse zzycourse) {
		this.zzycourse = zzycourse;
	}

	public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTemporalInterva() {
        return temporalInterva;
    }

    public void setTemporalInterva(Integer temporalInterva) {
        this.temporalInterva = temporalInterva;
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
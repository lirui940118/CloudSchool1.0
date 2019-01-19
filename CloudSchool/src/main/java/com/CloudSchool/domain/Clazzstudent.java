package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.annotation.DateTimeFormat;
@Mapper
public class Clazzstudent {
    private Integer id;

    private Integer cid;

    private Integer sid;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") 
    private Date starttime;

    private Date endtime;

    private Integer status;
    
    //学生对象
    private CqjStudent stu;
    
    //班级对象
    private Clazz cla;
   


    public Clazz getCla() {
		return cla;
	}

	public void setCla(Clazz cla) {
		this.cla = cla;
	}

	public CqjStudent getStu() {
		return stu;
	}

	public void setStu(CqjStudent stu) {
		this.stu = stu;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
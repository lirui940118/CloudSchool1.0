package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Participationworkstu {
    private Integer id;

    private Integer wid;

    private Integer sid;

    private Integer istrue;

    private Integer iscorrect;
    
    @JsonFormat(pattern="yyy-MM-dd hh:ss",timezone="GMT+8")//出去数据格式
    @DateTimeFormat(pattern="yyyy-MM-dd")		//进来数据格式
    private Date time;

    private Integer status;

    private String user1;

    private String user2;

    private String user3;

    private String user4;

    private String user5;
    
    private CqjStudent cqjStudent;
    private Workgrade workgrade;
	public Workgrade getWorkgrade() {
		return workgrade;
	}

	public void setWorkgrade(Workgrade workgrade) {
		this.workgrade = workgrade;
	}

	public CqjStudent getCqjStudent() {
		return cqjStudent;
	}

	public void setCqjStudent(CqjStudent cqjStudent) {
		this.cqjStudent = cqjStudent;
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getIstrue() {
        return istrue;
    }

    public void setIstrue(Integer istrue) {
        this.istrue = istrue;
    }

    public Integer getIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(Integer iscorrect) {
        this.iscorrect = iscorrect;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
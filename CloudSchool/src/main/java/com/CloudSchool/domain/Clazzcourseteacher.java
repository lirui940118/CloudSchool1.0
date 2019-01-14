package com.CloudSchool.domain;

import java.util.Date;

public class Clazzcourseteacher {
    private Integer id;

    private Integer clazzid;

    private Integer courseid;

    private Integer tid;

    private Date starttime;

    private Date endtime;

    private Integer status;
    
    private Integer ismaster;

    private Integer isteacher;
    
    /*年级名称*/
    private String greaName;
    public String getGreaName() {
		return greaName;
	}
    /**
     * 班级名称
     * @param greaName
     */
    private String cname;
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setGreaName(String greaName) {
		this.greaName = greaName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClazzid() {
        return clazzid;
    }

    public void setClazzid(Integer clazzid) {
        this.clazzid = clazzid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public Integer getIsmaster() {
        return ismaster;
    }

    public void setIsmaster(Integer ismaster) {
        this.ismaster = ismaster;
    }

    public Integer getIsteacher() {
        return isteacher;
    }

    public void setIsteacher(Integer isteacher) {
        this.isteacher = isteacher;
    }
}
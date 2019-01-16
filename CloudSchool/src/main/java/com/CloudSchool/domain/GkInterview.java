package com.CloudSchool.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GkInterview {
    private Integer ftId;

    private Integer ftPeople;

    private Integer ftObject;

    private Date ftStarttime;

    private Integer ftTime;

    private String ftProblem;

    private String peopleProposal;

    private String ftObjectExplain;

    private Date creationTime;

    private Date updateTime;

    private String founder;

    private Integer status;

    private String by1;

    private String by2;

    private String by3;

    private String by4;

    private String by5;
    
    private String ftstartStr;
    
    private String peoplename;
    private String objectname;
    private Integer userid;
    private String startStr;
	private String endStr;
    
	
	
	public String getFtstartStr() {
		
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ftstartStr);
	}
	public void setFtstartStr(String ftstartStr) {
		this.ftstartStr = ftstartStr;
	}
	public String getStartStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startStr);
	}
	public void setStartStr(String startStr) {
		this.startStr = startStr;
	}
	public String getEndStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endStr);
	}
	public void setEndStr(String endStr) {
		this.endStr = endStr;
	}
    public String getPeoplename() {
		return peoplename;
	}

	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getFtId() {
        return ftId;
    }

    public void setFtId(Integer ftId) {
        this.ftId = ftId;
    }

    public Integer getFtPeople() {
        return ftPeople;
    }

    public void setFtPeople(Integer ftPeople) {
        this.ftPeople = ftPeople;
    }

    public Integer getFtObject() {
        return ftObject;
    }

    public void setFtObject(Integer ftObject) {
        this.ftObject = ftObject;
    }

    public String getFtStarttime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ftStarttime);
    }

    public void setFtStarttime(Date ftStarttime) {
        this.ftStarttime = ftStarttime;
    }

    public Integer getFtTime() {
        return ftTime;
    }

    public void setFtTime(Integer ftTime) {
        this.ftTime = ftTime;
    }

    public String getFtProblem() {
        return ftProblem;
    }

    public void setFtProblem(String ftProblem) {
        this.ftProblem = ftProblem;
    }

    public String getPeopleProposal() {
        return peopleProposal;
    }

    public void setPeopleProposal(String peopleProposal) {
        this.peopleProposal = peopleProposal;
    }

    public String getFtObjectExplain() {
        return ftObjectExplain;
    }

    public void setFtObjectExplain(String ftObjectExplain) {
        this.ftObjectExplain = ftObjectExplain;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3;
    }

    public String getBy4() {
        return by4;
    }

    public void setBy4(String by4) {
        this.by4 = by4;
    }

    public String getBy5() {
        return by5;
    }

    public void setBy5(String by5) {
        this.by5 = by5;
    }
}
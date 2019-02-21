package com.CloudSchool.domain;

import java.util.Date;

public class GkQuestionnaire {
	//员工名称
	private String staffname;
	//问卷类型名称
	private String wjTypeName;
	//问卷选项类型名称
	private String wjxxTypeName;
	
	public String getWjxxTypeName() {
		return wjxxTypeName;
	}

	public void setWjxxTypeName(String wjxxTypeName) {
		this.wjxxTypeName = wjxxTypeName;
	}

	public String getWjTypeName() {
		return wjTypeName;
	}

	public void setWjTypeName(String wjTypeName) {
		this.wjTypeName = wjTypeName;
	}

	private String startStr;
	private String endStr;
	private Date starttime;		//开始时间
	private Date endtime;		//结束时间
	private Integer currentPage;//当前页
	private Integer pageSize;	//每页显示行数
	
    public String getStartStr() {
		return startStr;
	}

	public void setStartStr(String startStr) {
		this.startStr = startStr;
	}

	public String getEndStr() {
		return endStr;
	}

	public void setEndStr(String endStr) {
		this.endStr = endStr;
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

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	private Integer wjId;

    private String wjName;

    private Integer wjTypeId;

    private Integer wjPublisher;

    private String wjObject;

    private Date wjFbTime;

    private Integer wjxxTypeId;

    private String wjExplain;

    private Integer wjNum;

    private Date creationTime;

    private Date updateTime;

    private String founder;

    private Integer status;

    private String by1;

    private String by2;

    private String by3;

    private String by4;

    private String by5;

    public Integer getWjId() {
        return wjId;
    }

    public void setWjId(Integer wjId) {
        this.wjId = wjId;
    }

    public String getWjName() {
        return wjName;
    }

    public void setWjName(String wjName) {
        this.wjName = wjName;
    }

    public Integer getWjTypeId() {
        return wjTypeId;
    }

    public void setWjTypeId(Integer wjTypeId) {
        this.wjTypeId = wjTypeId;
    }

    public Integer getWjPublisher() {
        return wjPublisher;
    }

    public void setWjPublisher(Integer wjPublisher) {
        this.wjPublisher = wjPublisher;
    }

    public String getWjObject() {
        return wjObject;
    }

    public void setWjObject(String wjObject) {
        this.wjObject = wjObject;
    }

    public Date getWjFbTime() {
        return wjFbTime;
    }

    public void setWjFbTime(Date wjFbTime) {
        this.wjFbTime = wjFbTime;
    }

    public Integer getWjxxTypeId() {
        return wjxxTypeId;
    }

    public void setWjxxTypeId(Integer wjxxTypeId) {
        this.wjxxTypeId = wjxxTypeId;
    }

    public String getWjExplain() {
        return wjExplain;
    }

    public void setWjExplain(String wjExplain) {
        this.wjExplain = wjExplain;
    }

    public Integer getWjNum() {
        return wjNum;
    }

    public void setWjNum(Integer wjNum) {
        this.wjNum = wjNum;
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
    
    public GkQuestionnaire() {
		// TODO Auto-generated constructor stub
		this.currentPage=1;
		this.pageSize=1;
	}
}
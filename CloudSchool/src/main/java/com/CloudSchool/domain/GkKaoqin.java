package com.CloudSchool.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GkKaoqin {
    private Integer kqId;

    private Integer uid;

    private Date kqTime;

    private Integer kqStateId;

    private Date creationTime;

    private Date updateTime;

    private String founder;

    private Integer status;

    private String by1;

    private String by2;

    private String by3;

    private String by4;

    private String by5;
    
    
    private Integer yi;	//正常
    private Integer er;	//迟到
    private Integer san;//早退
    private Integer si;//请假
    private Integer wu;//旷工
    public Integer getYi() {
		return yi;
	}
	public void setYi(Integer yi) {
		this.yi = yi;
	}
	public Integer getEr() {
		return er;
	}
	public void setEr(Integer er) {
		this.er = er;
	}
	public Integer getSan() {
		return san;
	}
	public void setSan(Integer san) {
		this.san = san;
	}
	public Integer getSi() {
		return si;
	}
	public void setSi(Integer si) {
		this.si = si;
	}
	public Integer getWu() {
		return wu;
	}
	public void setWu(Integer wu) {
		this.wu = wu;
	}

	private String positionname; //职位名称
    private String staffname;	 //姓名
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
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.startStr = startStr;
		try {
			this.starttime=simpleDateFormat.parse(startStr);
		} catch (Exception e) {
			// TODO: handle exception
			this.startStr=null;
		}
	}
	public String getEndStr() {
		return endStr;
	}
	public void setEndStr(String endStr) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.endStr = endStr;
		try {
			this.endtime=simpleDateFormat.parse(endStr);
		} catch (Exception e) {
			// TODO: handle exception
			this.endStr=null;
		}
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
	public GkKaoqin() {
		// TODO Auto-generated constructor stub
		this.currentPage=1;
		this.pageSize=1;
	}
	
	
	
	
    

	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public Integer getKqId() {
        return kqId;
    }

    public void setKqId(Integer kqId) {
        this.kqId = kqId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getKqTime() {
        return kqTime;
    }

    public void setKqTime(Date kqTime) {
        this.kqTime = kqTime;
    }

    public Integer getKqStateId() {
        return kqStateId;
    }

    public void setKqStateId(Integer kqStateId) {
        this.kqStateId = kqStateId;
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
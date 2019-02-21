package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Clazz {
    private Integer id;

    private String cname;

    private Integer gid;

    private Integer mid;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") 
    private String startdate;

    private Integer count;

    private Date enddate;

    private String pc;

    private Integer status;
    
    //班级中班主任对象
    private CqjStaff master;
    
    //班级中任课教员集合
    private List<Clazzcourseteacher> list;
    
    //班级中目前正常学员的人数
    private Integer normalCount;
    
    //学员集合
    private List<CqjStudent> list2;
    
    private ZzyGrade zzygradeobj;
  
	public ZzyGrade getZzygradeobj() {
		return zzygradeobj;
	}

	public void setZzygradeobj(ZzyGrade zzygradeobj) {
		this.zzygradeobj = zzygradeobj;
	}

	public List<CqjStudent> getList2() {
		return list2;
	}

	public void setList2(List<CqjStudent> list2) {
		this.list2 = list2;
	}

	public Integer getNormalCount() {
		return normalCount;
	}

	public void setNormalCount(Integer normalCount) {
		this.normalCount = normalCount;
	}

	public CqjStaff getMaster() {
		return master;
	}

	public void setMaster(CqjStaff master) {
		this.master = master;
	}

	public List<Clazzcourseteacher> getList() {
		return list;
	}

	public void setList(List<Clazzcourseteacher> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
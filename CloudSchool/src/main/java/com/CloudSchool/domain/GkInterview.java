package com.CloudSchool.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class GkInterview implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7526476306074535018L;

	private Integer ftId;

	private List<GkInterview> list;
	
	

	public List<GkInterview> getList() {
		return list;
	}
	public void setList(List<GkInterview> list) {
		this.list = list;
	}

	private Integer ftPeople;

    private Integer ftObject;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    private Integer cid;
    
    public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	private String startStr;
	private String endStr;
	private Integer currentPage;//当前页
	private Integer pageSize;	//每页显示行数
	private Date starttime;		//开始时间
	private Date endtime;		//结束时间
	private String studentnub;	//学号
	private String studentname;	//学生名称
	private String staffnub;	//员工工号
	private String staffname;	//员工名称
	private String parentsname;	//家长名称
	private Integer[] shuzu;
    
	
	public Integer[] getShuzu() {
		return shuzu;
	}
	public void setShuzu(Integer[] shuzu) {
		this.shuzu = shuzu;
	}
	public String getStudentnub() {
		return studentnub;
	}
	public void setStudentnub(String studentnub) {
		this.studentnub = studentnub;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStaffnub() {
		return staffnub;
	}
	public void setStaffnub(String staffnub) {
		this.staffnub = staffnub;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getParentsname() {
		return parentsname;
	}
	public void setParentsname(String parentsname) {
		this.parentsname = parentsname;
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
	public GkInterview() {
		// TODO Auto-generated constructor stub
		this.currentPage=1;
		this.pageSize=1;
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
	public String getFtstartStr() {
		return ftstartStr;
	}
	public void setFtstartStr(String ftstartStr) {
		this.ftstartStr = ftstartStr;
	}
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
    	if(ftStarttime==null) {
    		return null;
    	}
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
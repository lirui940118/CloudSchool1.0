package com.CloudSchool.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GkQuestionnaire {
	//问卷测试选择id
	private Integer wjcs_id;
	

	public Integer getWjcs_id() {
		return wjcs_id;
	}

	public void setWjcs_id(Integer wjcs_id) {
		this.wjcs_id = wjcs_id;
	}

	//问卷调查对象userid
    private Integer o_id;
    //问卷调查对象年级id
    private Integer g_id;
    //问卷测试计分id
	private Integer wjcsjf_id;
    
    
    
   

	public Integer getWjcsjf_id() {
		return wjcsjf_id;
	}

	public void setWjcsjf_id(Integer wjcsjf_id) {
		this.wjcsjf_id = wjcsjf_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getO_id() {
		return o_id;
	}

	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}

	//问卷调查对象名称
	private String peoplename;
	
	
	public String getPeoplename() {
		return peoplename;
	}

	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}
	//题目集合
	private List<GkQuestionnairetm> listtm;
	//选项集合
	private List<GkQuestionnairexx> listxx;
	
	
	
	
    public List<GkQuestionnairexx> getListxx() {
		return listxx;
	}

	public void setListxx(List<GkQuestionnairexx> listxx) {
		this.listxx = listxx;
	}

	public List<GkQuestionnairetm> getListtm() {
		return listtm;
	}

	public void setListtm(List<GkQuestionnairetm> listtm) {
		this.listtm = listtm;
	}
	//班级数组
	private Integer[] banji;
	//员工数组
	private List<CqjUser> yuangong;
	//家长数组
	private Integer[] jiazhang;
	//gk做题人userid
    private Integer zId;
    
    
    
	

	
	
	

	public Integer getzId() {
		return zId;
	}

	public void setzId(Integer zId) {
		this.zId = zId;
	}

	public Integer[] getBanji() {
		return banji;
	}

	public void setBanji(Integer[] banji) {
		this.banji = banji;
	}


	public List<CqjUser> getYuangong() {
		return yuangong;
	}

	public void setYuangong(List<CqjUser> yuangong) {
		this.yuangong = yuangong;
	}

	public Integer[] getJiazhang() {
		return jiazhang;
	}

	public void setJiazhang(Integer[] jiazhang) {
		this.jiazhang = jiazhang;
	}

	//数组
	private Integer[] shuzu;
	public Integer[] getShuzu() {
		return shuzu;
	}

	public void setShuzu(Integer[] shuzu) {
		this.shuzu = shuzu;
	}

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
	
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	private Date starttime;		//开始时间
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
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

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
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
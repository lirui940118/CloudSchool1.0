package com.CloudSchool.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.CloudSchool.domain.cqjvo.StudentTestVo;

public class CqjStudent implements Serializable{
	
	//gk用户id
	private Integer userid;
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	//write by lirui 
	//当前所在班级名称
	private String className;
	//学员状态（正常,毕业） 
	private int statusValue;
	//班级结束时间（最近一次班级结束时间）
	private String endtime;
	//学员图片地址
	private String url;
	
    private Integer studentid;

    private String studentname;

    private String studentnub;

    private Integer positionid;

    private Integer sex;

    private Integer age;

    private String phone;

    private String idcard;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") 
    private Date birthday;
    
    private String address;

    private String email;

    private String standby1;

    private String standby2;

    private String standby3;

    private String standby4;

    private String standby5;


    private Integer parentsid;
    
    private String parentsname;

    //学员在当前班级被当前教员提出问题的总次数
    private Integer count;
    //学员回答问题的回答出来的次数
    private Integer count2;

    

    private List<StudentTestVo> stList=new ArrayList<StudentTestVo>();
    
    
    public List<StudentTestVo> getStList() {
		return stList;
	}

	public void setStList(List<StudentTestVo> stList) {
		this.stList = stList;
	}

	public String getParentsname() {
		return parentsname;
	}

	public void setParentsname(String parentsname) {
		this.parentsname = parentsname;
	}

	public Integer getParentsid() {
		return parentsid;
	}

	public void setParentsid(Integer parentsid) {
		this.parentsid = parentsid;
	}

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount2() {
		return count2;
	}

	public void setCount2(Integer count2) {
		this.count2 = count2;

	}

	public String getClassName() {
		return className;
	}

	public void setClassname(String className) {
		this.className = className;
	}

	

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(int statusValue) {
		this.statusValue = statusValue;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentnub() {
        return studentnub;
    }

    public void setStudentnub(String studentnub) {
        this.studentnub = studentnub;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStandby1() {
        return standby1;
    }

    public void setStandby1(String standby1) {
        this.standby1 = standby1;
    }

    public String getStandby2() {
        return standby2;
    }

    public void setStandby2(String standby2) {
        this.standby2 = standby2;
    }

    public String getStandby3() {
        return standby3;
    }

    public void setStandby3(String standby3) {
        this.standby3 = standby3;
    }

    public String getStandby4() {
        return standby4;
    }

    public void setStandby4(String standby4) {
        this.standby4 = standby4;
    }

    public String getStandby5() {
        return standby5;
    }

    public void setStandby5(String standby5) {
        this.standby5 = standby5;
    }
}
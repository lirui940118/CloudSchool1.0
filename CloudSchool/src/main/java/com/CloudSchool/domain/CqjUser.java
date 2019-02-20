package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class CqjUser {
	//用户编号
    private Integer userid;
    //登录账号
    private String username;
    //登录密码
    private String password;
    //角色编号
    private Integer roleid;
    //用户类型编号
    private Integer usertypeid;
    //用户类型
    private Integer usertypenub;
    //创建时间
    private Date creationtime;
    //修改时间
    private Date modificationtime;
    //状态
    private Integer status;
    //创建人
    private Integer uid;
    //备注
    private String remark;

    private String standby1;

    private String standby2;

    private String standby3;

    private String standby4;

    private String standby5;
    //用户名称
    private String name;
    //用户的工号，学号，家长号
    private String usernub;
    //角色名称
    private String rolename;
    //职位编号
    private Integer positionid;
    //职位名称
    private String positionname;
    //性别
    private Integer sex;
    //年龄
    private Integer age;
    //手机号
    private String phone;
    //身份证
    private String idcard;
    //生日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;
    //住址
    private String address;
    //邮箱
    private String email;
    //头像路径
    private String url;
    
    //班级组用于接收数据库返回的值
    private String clazzids;
    
    //能访问的班级组
    private List<String> clazzidsList;
    
    //能访问的设置模块组
    private List<CqjModule> moduleSettingList;
    
    //能访问的列表模块组
    private List<CqjModule> moduleList;
    
    //能访问的数据模块组
    private List<CqjModule> moduleInfoList;
    
    //所有能访问模块组
    private List<CqjModule> moduleAllList;
    //首页路径
    private String homeUrl;
    
    
    
	

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CqjModule> getModuleAllList() {
		return moduleAllList;
	}

	public void setModuleAllList(List<CqjModule> moduleAllList) {
		this.moduleAllList = moduleAllList;
	}

	public List<CqjModule> getModuleSettingList() {
		return moduleSettingList;
	}

	public void setModuleSettingList(List<CqjModule> moduleSettingList) {
		this.moduleSettingList = moduleSettingList;
	}

	public List<CqjModule> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<CqjModule> moduleList) {
		this.moduleList = moduleList;
	}

	public List<CqjModule> getModuleInfoList() {
		return moduleInfoList;
	}

	public void setModuleInfoList(List<CqjModule> moduleInfoList) {
		this.moduleInfoList = moduleInfoList;
	}

	public List<String> getClazzidsList() {
		return clazzidsList;
	}

	public void setClazzidsList(List<String> clazzidsList) {
		this.clazzidsList = clazzidsList;
	}

	public String getClazzids() {
		return clazzids;
	}

	public void setClazzids(String clazzids) {
		this.clazzids = clazzids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsernub() {
		return usernub;
	}

	public void setUsernub(String usernub) {
		this.usernub = usernub;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getPositionid() {
		return positionid;
	}

	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(Integer usertypeid) {
        this.usertypeid = usertypeid;
    }

    public Integer getUsertypenub() {
        return usertypenub;
    }

    public void setUsertypenub(Integer usertypenub) {
        this.usertypenub = usertypenub;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Date getModificationtime() {
        return modificationtime;
    }

    public void setModificationtime(Date modificationtime) {
        this.modificationtime = modificationtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
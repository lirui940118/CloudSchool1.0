package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ZzyVersion {
    private Integer vid;

    private String versionof;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") 
    private String creatTime;

    private Date modificationtime;

    private Integer status;

    private Integer uid;

    private String remark;

    private String user1;

    private String user2;

    private String user3;

    private String user4;

    private String user5;
    
    private List<ZzyGrade> list;
    
    //专业集合
    private List<ZzyMajor> list2;

    public List<ZzyMajor> getList2() {
		return list2;
	}

	public void setList2(List<ZzyMajor> list2) {
		this.list2 = list2;
	}

	public List<ZzyGrade> getList() {
		return list;
	}

	public void setList(List<ZzyGrade> list) {
		this.list = list;
	}

	public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVersionof() {
        return versionof;
    }

    public void setVersionof(String versionof) {
        this.versionof = versionof;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
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
package com.CloudSchool.domain;

import java.util.Date;
import java.util.List;

public class Topic {
    private Integer id;

    private Integer tid;

    private Date time;

    private Integer uid;

    private Integer cid;

    private Integer kid;

    private Integer rank;

    private String url;

    private Integer examdot;

    private Integer status;
    
    /*分数*/
    private Integer user1;

    private String user2;

    private String user3;

    private String user4;

    private String user5;
    
    private Wtrecord wtrecord;

 


	public Wtrecord getWtrecord() {
		return wtrecord;
	}

	public void setWtrecord(Wtrecord wtrecord) {
		this.wtrecord = wtrecord;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getExamdot() {
        return examdot;
    }

    public void setExamdot(Integer examdot) {
        this.examdot = examdot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

   
    public Integer getUser1() {
		return user1;
	}

	public void setUser1(Integer user1) {
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
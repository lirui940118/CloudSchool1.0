package com.CloudSchool.domain;

import java.util.Date;

public class Testinfo {
    private Integer id;

    private Integer testid;

    private Integer tid;

    private Date time;

    private Integer status;

    private String user1;

    private String user2;

    private String user3;

    private String user4;

    private String user5;
    private TopicWithBLOBs topicWithBLOBs;
   

	public TopicWithBLOBs getTopicWithBLOBs() {
		return topicWithBLOBs;
	}

	public void setTopicWithBLOBs(TopicWithBLOBs topicWithBLOBs) {
		this.topicWithBLOBs = topicWithBLOBs;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
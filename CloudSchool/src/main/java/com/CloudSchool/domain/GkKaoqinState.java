package com.CloudSchool.domain;

import java.util.Date;

public class GkKaoqinState {
	//write by lirui
	//總次數（數據統計使用）
	private Integer totalCount;
	
	
    private Integer kqStateId;

    private String kqStateName;

    private Date creationTime;

    private Date updateTime;

    private String founder;

    private Integer status;

    private String by1;

    private String by2;

    private String by3;

    private String by4;

    private String by5;

    
    public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getKqStateId() {
        return kqStateId;
    }

    public void setKqStateId(Integer kqStateId) {
        this.kqStateId = kqStateId;
    }

    public String getKqStateName() {
        return kqStateName;
    }

    public void setKqStateName(String kqStateName) {
        this.kqStateName = kqStateName;
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
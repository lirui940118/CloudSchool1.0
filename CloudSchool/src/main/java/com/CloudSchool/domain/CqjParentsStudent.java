package com.CloudSchool.domain;

import java.util.Date;

public class CqjParentsStudent {
    private Integer id;

    private Integer parentsid;

    private Integer studentid;

    private Date creationtime;

    private Integer status;

    private String standby1;

    private String standby2;

    private String standby3;

    private String standby4;

    private String standby5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentsid() {
        return parentsid;
    }

    public void setParentsid(Integer parentsid) {
        this.parentsid = parentsid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
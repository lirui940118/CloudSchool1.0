package com.CloudSchool.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notice {
    private Integer id;

    private String title;

    private Integer sender;

    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date time;
    //接收者范围：0全部、教职工、学生、家长、年级、班级
    private Integer receiverrange;
    //年级id或班级id
    private Integer receiverid;

    private String readrecord;

    private String content;
    
    private String sendername;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getReceiverrange() {
        return receiverrange;
    }

    public void setReceiverrange(Integer receiverrange) {
        this.receiverrange = receiverrange;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public String getReadrecord() {
        return readrecord;
    }

    public void setReadrecord(String readrecord) {
        this.readrecord = readrecord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
}
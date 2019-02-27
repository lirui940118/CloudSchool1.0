package com.CloudSchool.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {
    private Integer id;

    private String title;

    private Integer sender;

    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date time;

    private String content;
    //接收者数组
    private int[] receiver; 
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public int[] getReceiver() {
		return receiver;
	}

	public void setReceiver(int[] receiver) {
		this.receiver = receiver;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
}
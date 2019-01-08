package com.CloudSchool.domain;

import java.util.Date;

public class Notice {
    private Integer id;

    private String title;

    private Integer sender;

    private String url;

    private Date time;

    private Integer receiverrange;

    private Integer receiverid;

    private String readrecord;

    private String content;

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
}
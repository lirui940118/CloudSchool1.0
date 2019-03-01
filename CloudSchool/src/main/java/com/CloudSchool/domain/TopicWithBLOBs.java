package com.CloudSchool.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class TopicWithBLOBs extends Topic {
    private String topicconten;

    private String result;

    private String analysis;
    private List<Topicoption> list;
    private Topictype topicType;
    
    private List<Topicoption> topicoptionList;
	public List<Topicoption> getTopicoptionList() {
		return topicoptionList;
	}
	/*作业中题目编号*/
	private Integer workid;
	
	public Integer getWorkid() {
		return workid;
	}

	public void setWorkid(Integer workid) {
		this.workid = workid;
	}

	public void setTopicoptionList(List<Topicoption> topicoptionList) {
		this.topicoptionList = topicoptionList;
	}

	public Topictype getTopicType() {
		return topicType;
	}

	public void setTopicType(Topictype topicType) {
		this.topicType = topicType;
	}

	public List<Topicoption> getList() {
		return list;
	}

	public void setList(List<Topicoption> list) {
		this.list = list;
	}

	public String getTopicconten() {
        return topicconten;
    }

    public void setTopicconten(String topicconten) {
        this.topicconten = topicconten;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
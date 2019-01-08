package com.CloudSchool.domain;

public class TopicWithBLOBs extends Topic {
    private String topicconten;

    private String result;

    private String analysis;

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
package com.moas.crawler.model;

import java.util.Date;

public class TopWords {
    private Long wordid;

    private Long topid;

    private String word;

    private String wordtype;

    private Date createtime;

    private Date updatetime;

    private Byte status;

    private Integer visits;

    public Long getWordid() {
        return wordid;
    }

    public void setWordid(Long wordid) {
        this.wordid = wordid;
    }

    public Long getTopid() {
        return topid;
    }

    public void setTopid(Long topid) {
        this.topid = topid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getWordtype() {
        return wordtype;
    }

    public void setWordtype(String wordtype) {
        this.wordtype = wordtype == null ? null : wordtype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "TopWords{" +
                "wordid=" + wordid +
                ", topid=" + topid +
                ", word='" + word + '\'' +
                ", wordtype='" + wordtype + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", status=" + status +
                ", visits=" + visits +
                '}';
    }
}
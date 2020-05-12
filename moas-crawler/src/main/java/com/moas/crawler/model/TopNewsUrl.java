package com.moas.crawler.model;

public class TopNewsUrl {
    private Integer newsid;

    private String newsname;

    private String newsurl;

    private String newsproduct;

    private Byte newstype;

    private String cron;

    private Byte status;

    private String cookie;

    private String header;

    private String param;

    private Byte requesttype;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname == null ? null : newsname.trim();
    }

    public String getNewsurl() {
        return newsurl;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl == null ? null : newsurl.trim();
    }

    public String getNewsproduct() {
        return newsproduct;
    }

    public void setNewsproduct(String newsproduct) {
        this.newsproduct = newsproduct == null ? null : newsproduct.trim();
    }

    public Byte getNewstype() {
        return newstype;
    }

    public void setNewstype(Byte newstype) {
        this.newstype = newstype;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public Byte getRequesttype() {
        return requesttype;
    }

    public void setRequesttype(Byte requesttype) {
        this.requesttype = requesttype;
    }

    @Override
    public String toString() {
        return "TopNewsUrl{" +
                "newsid=" + newsid +
                ", newsname='" + newsname + '\'' +
                ", newsurl='" + newsurl + '\'' +
                ", newsproduct='" + newsproduct + '\'' +
                ", newstype=" + newstype +
                ", cron='" + cron + '\'' +
                ", status=" + status +
                ", cookie='" + cookie + '\'' +
                ", header='" + header + '\'' +
                ", param='" + param + '\'' +
                ", requesttype=" + requesttype +
                '}';
    }
}
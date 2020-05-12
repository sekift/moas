package com.moas.back.model;

import java.util.Date;

public class TopNews {
    private Long topid;

    private String md5;

    private Integer sortindex;

    private String content;

    private Integer toprank;

    private String linkurl;

    private String imageurl;

    private Integer sourceid;

    private String source;

    private Date posttime;

    private Date createtime;

    private Date updatetime;

    private Byte status;

    private Integer visits;

    private Integer noteint;

    private String notestring;

    private String remark;

    public Long getTopid() {
        return topid;
    }

    public void setTopid(Long topid) {
        this.topid = topid;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public Integer getSortindex() {
        return sortindex;
    }

    public void setSortindex(Integer sortindex) {
        this.sortindex = sortindex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getToprank() {
        return toprank;
    }

    public void setToprank(Integer toprank) {
        this.toprank = toprank;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Integer getSourceid() {
        return sourceid;
    }

    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
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

    public Integer getNoteint() {
        return noteint;
    }

    public void setNoteint(Integer noteint) {
        this.noteint = noteint;
    }

    public String getNotestring() {
        return notestring;
    }

    public void setNotestring(String notestring) {
        this.notestring = notestring == null ? null : notestring.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "TopNews{" +
                "topid=" + topid +
                ", md5='" + md5 + '\'' +
                ", sortindex=" + sortindex +
                ", content='" + content + '\'' +
                ", toprank=" + toprank +
                ", linkurl='" + linkurl + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", sourceid=" + sourceid +
                ", source='" + source + '\'' +
                ", posttime=" + posttime +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", status=" + status +
                ", visits=" + visits +
                ", noteint=" + noteint +
                ", notestring='" + notestring + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
package com.fc.entity;

import java.util.Date;

public class Exam {
    private Integer eid;

    private String pname;

    private Integer cno;

    private Integer userid;

    private Integer classid;

    private Integer singlenumber;

    private Integer singlecore;

    private Integer multiplenumber;

    private Integer multiplecore;

    private Date examdate;

    private Date examtime;

    private Integer testtime;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getSinglenumber() {
        return singlenumber;
    }

    public void setSinglenumber(Integer singlenumber) {
        this.singlenumber = singlenumber;
    }

    public Integer getSinglecore() {
        return singlecore;
    }

    public void setSinglecore(Integer singlecore) {
        this.singlecore = singlecore;
    }

    public Integer getMultiplenumber() {
        return multiplenumber;
    }

    public void setMultiplenumber(Integer multiplenumber) {
        this.multiplenumber = multiplenumber;
    }

    public Integer getMultiplecore() {
        return multiplecore;
    }

    public void setMultiplecore(Integer multiplecore) {
        this.multiplecore = multiplecore;
    }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }

    public Integer getTesttime() {
        return testtime;
    }

    public void setTesttime(Integer testtime) {
        this.testtime = testtime;
    }
}
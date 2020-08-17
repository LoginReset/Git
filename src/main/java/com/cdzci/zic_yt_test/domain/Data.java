package com.cdzci.zic_yt_test.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Data implements Serializable {
    private static final long serialVersionUID = -2108579645566013560L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uid;
    private String content;
    private Integer year;
    private Integer month;
    private Integer day;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;

    public Data() {
    }

    public Data(String uid, String content, Integer year, Integer month, Integer day, Date createDate) {
        this.uid = uid;
        this.content = content;
        this.year = year;
        this.month = month;
        this.day = day;
        this.createDate = createDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", content='" + content + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", createDate=" + createDate +
                '}';
    }
}

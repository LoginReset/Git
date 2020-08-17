package com.cdzci.zic_yt_test.vo.svo;

public class DataSVO {
    private String uid;
    private String content;
    private String createDate;

    public DataSVO() {
    }

    public DataSVO(String uid, String content, String createDate) {
        this.uid = uid;
        this.content = content;
        this.createDate = createDate;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "DataSVO{" +
                "uid='" + uid + '\'' +
                ", content='" + content + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}

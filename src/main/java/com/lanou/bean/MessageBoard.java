package com.lanou.bean;

/**
 * Created by dllo on 2017/8/18.
 */
public class MessageBoard {


    private Integer id;
    private String content;
    private Integer upCount;
    private Integer downCount;


    @Override
    public String toString() {
        return "MessageBoard{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", upCount='" + upCount + '\'' +
                ", downCount='" + downCount + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }
}

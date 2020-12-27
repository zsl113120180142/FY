package com.gannan.court.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Whzb {

    private Integer id;

    private String category;

    private String title;

    private Integer homepage;

    private String picture;

    //要接收日期格式的json数据
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date time;

    private String author;

    private String externallinks;

    private String source;

    private Integer puton;

    private String categoryname;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getHomepage() {
        return homepage;
    }

    public void setHomepage(Integer homepage) {
        this.homepage = homepage;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getExternallinks() {
        return externallinks;
    }

    public void setExternallinks(String externallinks) {
        this.externallinks = externallinks == null ? null : externallinks.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getPuton() {
        return puton;
    }

    public void setPuton(Integer puton) {
        this.puton = puton;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Whzb{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", homepage=" + homepage +
                ", picture='" + picture + '\'' +
                ", time=" + time +
                ", author='" + author + '\'' +
                ", externallinks='" + externallinks + '\'' +
                ", source='" + source + '\'' +
                ", puton=" + puton +
                ", categoryname='" + categoryname + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
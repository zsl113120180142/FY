package com.gannan.court.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


public class Picture {

    private Integer id;

    private String picture;

    private String title;

    private Integer homepage;

    private String category;

    private String categoryname;

    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", title='" + title + '\'' +
                ", homepage=" + homepage +
                ", category='" + category + '\'' +
                ", categoryname='" + categoryname + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
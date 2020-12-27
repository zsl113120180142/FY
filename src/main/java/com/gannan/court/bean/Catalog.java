package com.gannan.court.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Catalog {

    private Integer id;

    private String category;

    private String titlename;

    private String hcategory;

    private String htitlename;

    private List<Catalog> catalogList;

    private List<Dwgz> dwgzList;

    private List<News> newsList;

    private String url;

    private String areaUrl;

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

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename == null ? null : titlename.trim();
    }

    public String getHcategory() {
        return hcategory;
    }

    public void setHcategory(String hcategory) {
        this.hcategory = hcategory == null ? null : hcategory.trim();
    }

    public String getHtitlename() {
        return htitlename;
    }

    public void setHtitlename(String htitlename) {
        this.htitlename = htitlename == null ? null : htitlename.trim();
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    public List<Dwgz> getDwgzList() {
        return dwgzList;
    }

    public void setDwgzList(List<Dwgz> dwgzList) {
        this.dwgzList = dwgzList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAreaUrl() {
        return areaUrl;
    }

    public void setAreaUrl(String areaUrl) {
        this.areaUrl = areaUrl;
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", titlename='" + titlename + '\'' +
                ", hcategory='" + hcategory + '\'' +
                ", htitlename='" + htitlename + '\'' +
                ", catalogList=" + catalogList +
                ", dwgzList=" + dwgzList +
                ", newsList=" + newsList +
                ", url='" + url + '\'' +
                ", areaUrl='" + areaUrl + '\'' +
                '}';
    }
}
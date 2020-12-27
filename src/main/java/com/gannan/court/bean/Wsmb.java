package com.gannan.court.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Wsmb {

    private Integer id;

    private String title;

    private String filepath;

    //要接收日期格式的json数据
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date time;

    private Integer puton;

    private String filename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPuton() {
        return puton;
    }

    public void setPuton(Integer puton) {
        this.puton = puton;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    @Override
    public String toString() {
        return "Wsmb{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", filepath='" + filepath + '\'' +
                ", time=" + time +
                ", puton=" + puton +
                ", filename='" + filename + '\'' +
                '}';
    }
}
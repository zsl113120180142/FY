package com.gannan.court.dao;

import com.gannan.court.bean.Dwgz;
import com.gannan.court.bean.News;
import com.gannan.court.bean.NewsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExampleWithBLOBs(NewsExample example);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExampleWithBLOBs(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    //查询十条数据
    @Select("SELECT id,title,time FROM news WHERE homepage = 1 and puton = 1 ORDER BY time DESC LIMIT 10")
    List<News> selectTenNews();

    //图片新闻
    @Select("select id,title,picture from news WHERE category = 'tpxw' and homepage = 1 and puton = 1 ORDER BY time DESC LIMIT 5")
    List<News> selectPictureNews();

    //查询九条数据通过类别
    @Select("select id,title from news WHERE homepage = 1 and puton = 1 and category = #{category} ORDER BY time DESC LIMIT 9")
    List<News> selectNineByCategory(String category);

    //只显示五条数据
    @Select("select id,title,time from news WHERE category = #{category} and puton = 1 ORDER BY time DESC LIMIT 5")
    List<News> selectByCategory(String category);

    //上一页
    @Select("select id,title from news where puton = 1 and id<#{id} order by id desc limit 1")
    News selectLastById(Integer id);

    //下一页
    @Select("select id,title from news where puton = 1 and id>#{id} order by id asc limit 1")
    News selectNextById(Integer id);

    //只显示全部的标题
    @Select("select id,title,time,picture from news WHERE category = #{category} and puton = 1 ORDER BY time DESC")
    List<News> selectAllByCategory(String category);
}
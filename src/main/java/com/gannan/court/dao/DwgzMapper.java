package com.gannan.court.dao;

import com.gannan.court.bean.Dwgz;
import com.gannan.court.bean.DwgzExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DwgzMapper {
    int countByExample(DwgzExample example);

    int deleteByExample(DwgzExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dwgz record);

    int insertSelective(Dwgz record);

    List<Dwgz> selectByExampleWithBLOBs(DwgzExample example);

    List<Dwgz> selectByExample(DwgzExample example);

    Dwgz selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dwgz record, @Param("example") DwgzExample example);

    int updateByExampleWithBLOBs(@Param("record") Dwgz record, @Param("example") DwgzExample example);

    int updateByExample(@Param("record") Dwgz record, @Param("example") DwgzExample example);

    int updateByPrimaryKeySelective(Dwgz record);

    int updateByPrimaryKeyWithBLOBs(Dwgz record);

    int updateByPrimaryKey(Dwgz record);

    //只显示五条数据
    @Select("select id,title,time from dwgz WHERE category = #{category} and puton = 1 ORDER BY time DESC LIMIT 5")
    List<Dwgz> selectByCategory(String category);

    //只显示全部的标题
    @Select("select id,title,time from dwgz WHERE category = #{category} and puton = 1 ORDER BY time DESC")
    List<Dwgz> selectAllByCategory(String category);

    //上一页
    @Select("select id,title from dwgz where puton = 1 and id<#{id} order by id desc limit 1")
    Dwgz selectLastById(Integer id);

    //下一页
    @Select("select id,title from dwgz where puton = 1 and id>#{id} order by id asc limit 1")
    Dwgz selectNextById(Integer id);
}
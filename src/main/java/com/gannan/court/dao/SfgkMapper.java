package com.gannan.court.dao;

import com.gannan.court.bean.Dwgz;
import com.gannan.court.bean.Sfgk;
import com.gannan.court.bean.SfgkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SfgkMapper {
    int countByExample(SfgkExample example);

    int deleteByExample(SfgkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sfgk record);

    int insertSelective(Sfgk record);

    List<Sfgk> selectByExampleWithBLOBs(SfgkExample example);

    List<Sfgk> selectByExample(SfgkExample example);

    Sfgk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sfgk record, @Param("example") SfgkExample example);

    int updateByExampleWithBLOBs(@Param("record") Sfgk record, @Param("example") SfgkExample example);

    int updateByExample(@Param("record") Sfgk record, @Param("example") SfgkExample example);

    int updateByPrimaryKeySelective(Sfgk record);

    int updateByPrimaryKeyWithBLOBs(Sfgk record);

    int updateByPrimaryKey(Sfgk record);

    //公告栏
    @Select("select id,title from sfgk WHERE homepage = 1 and puton = 1")
    List<Sfgk> selectAllTitile();

    //上一页
    @Select("select id,title from sfgk where puton = 1 and id<#{id} order by id desc limit 1")
    Dwgz selectLastById(Integer id);

    //下一页
    @Select("select id,title from sfgk where puton = 1 and id>#{id} order by id asc limit 1")
    Dwgz selectNextById(Integer id);

    //只显示全部的标题
    @Select("select id,title,time from sfgk WHERE puton = 1 ORDER BY time DESC")
    List<Sfgk> selectAll();
}
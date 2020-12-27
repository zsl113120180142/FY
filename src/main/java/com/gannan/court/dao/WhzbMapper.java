package com.gannan.court.dao;

import com.gannan.court.bean.Dwgz;
import com.gannan.court.bean.Whzb;
import com.gannan.court.bean.WhzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WhzbMapper {
    int countByExample(WhzbExample example);

    int deleteByExample(WhzbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Whzb record);

    int insertSelective(Whzb record);

    List<Whzb> selectByExampleWithBLOBs(WhzbExample example);

    List<Whzb> selectByExample(WhzbExample example);

    Whzb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Whzb record, @Param("example") WhzbExample example);

    int updateByExampleWithBLOBs(@Param("record") Whzb record, @Param("example") WhzbExample example);

    int updateByExample(@Param("record") Whzb record, @Param("example") WhzbExample example);

    int updateByPrimaryKeySelective(Whzb record);

    int updateByPrimaryKeyWithBLOBs(Whzb record);

    int updateByPrimaryKey(Whzb record);

    //法学园地
    @Select("select id,title from whzb WHERE homepage = 1 and puton = 1 and category = #{category} ORDER BY time DESC LIMIT 9")
    List<Whzb> selectNineByCategory(String category);

    @Select("select id,title from whzb WHERE homepage = 1 and puton = 1 and category = #{category} ORDER BY time DESC LIMIT 5")
    List<Whzb> selecttitleByCategory(String category);

    //只显示全部的标题
    @Select("select id,title,time from whzb WHERE category = #{category} and puton = 1 ORDER BY time DESC")
    List<Whzb> selectAllByCategory(String category);
    
    //上一页
    @Select("select id,title from whzb where puton = 1 and id<#{id} order by id desc limit 1")
    Dwgz selectLastById(Integer id);

    //下一页
    @Select("select id,title from whzb where puton = 1 and id>#{id} order by id asc limit 1")
    Dwgz selectNextById(Integer id);
}
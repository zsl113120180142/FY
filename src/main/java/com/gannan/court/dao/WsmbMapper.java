package com.gannan.court.dao;

import com.gannan.court.bean.Whzb;
import com.gannan.court.bean.Wsmb;
import com.gannan.court.bean.WsmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WsmbMapper {
    int countByExample(WsmbExample example);

    int deleteByExample(WsmbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wsmb record);

    int insertSelective(Wsmb record);

    List<Wsmb> selectByExample(WsmbExample example);

    Wsmb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wsmb record, @Param("example") WsmbExample example);

    int updateByExample(@Param("record") Wsmb record, @Param("example") WsmbExample example);

    int updateByPrimaryKeySelective(Wsmb record);

    int updateByPrimaryKey(Wsmb record);

    //只显示全部的标题
    @Select("select id,title,time from wsmb WHERE puton = 1 ORDER BY time DESC")
    List<Wsmb> selectAll();
}
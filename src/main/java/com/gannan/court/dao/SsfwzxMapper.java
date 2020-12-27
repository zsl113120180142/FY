package com.gannan.court.dao;

import com.gannan.court.bean.Ssfwzx;
import com.gannan.court.bean.SsfwzxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsfwzxMapper {
    int countByExample(SsfwzxExample example);

    int deleteByExample(SsfwzxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ssfwzx record);

    int insertSelective(Ssfwzx record);

    List<Ssfwzx> selectByExampleWithBLOBs(SsfwzxExample example);

    List<Ssfwzx> selectByExample(SsfwzxExample example);

    Ssfwzx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ssfwzx record, @Param("example") SsfwzxExample example);

    int updateByExampleWithBLOBs(@Param("record") Ssfwzx record, @Param("example") SsfwzxExample example);

    int updateByExample(@Param("record") Ssfwzx record, @Param("example") SsfwzxExample example);

    int updateByPrimaryKeySelective(Ssfwzx record);

    int updateByPrimaryKeyWithBLOBs(Ssfwzx record);

    int updateByPrimaryKey(Ssfwzx record);
}
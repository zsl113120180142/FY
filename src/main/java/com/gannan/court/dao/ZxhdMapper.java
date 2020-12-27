package com.gannan.court.dao;

import com.gannan.court.bean.Zxhd;
import com.gannan.court.bean.ZxhdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZxhdMapper {
    int countByExample(ZxhdExample example);

    int deleteByExample(ZxhdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zxhd record);

    int insertSelective(Zxhd record);

    List<Zxhd> selectByExampleWithBLOBs(ZxhdExample example);

    List<Zxhd> selectByExample(ZxhdExample example);

    Zxhd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zxhd record, @Param("example") ZxhdExample example);

    int updateByExampleWithBLOBs(@Param("record") Zxhd record, @Param("example") ZxhdExample example);

    int updateByExample(@Param("record") Zxhd record, @Param("example") ZxhdExample example);

    int updateByPrimaryKeySelective(Zxhd record);

    int updateByPrimaryKeyWithBLOBs(Zxhd record);

    int updateByPrimaryKey(Zxhd record);
}
package com.gannan.court.dao;

import com.gannan.court.bean.Courtintroduce;
import com.gannan.court.bean.CourtintroduceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourtintroduceMapper {
    int countByExample(CourtintroduceExample example);

    int deleteByExample(CourtintroduceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Courtintroduce record);

    int insertSelective(Courtintroduce record);

    List<Courtintroduce> selectByExampleWithBLOBs(CourtintroduceExample example);

    List<Courtintroduce> selectByExample(CourtintroduceExample example);

    Courtintroduce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Courtintroduce record, @Param("example") CourtintroduceExample example);

    int updateByExampleWithBLOBs(@Param("record") Courtintroduce record, @Param("example") CourtintroduceExample example);

    int updateByExample(@Param("record") Courtintroduce record, @Param("example") CourtintroduceExample example);

    int updateByPrimaryKeySelective(Courtintroduce record);

    int updateByPrimaryKeyWithBLOBs(Courtintroduce record);

    int updateByPrimaryKey(Courtintroduce record);
}
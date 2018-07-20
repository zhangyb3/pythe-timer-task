package com.pythe.mapper;

import com.pythe.pojo.TblMatch;
import com.pythe.pojo.TblMatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblMatchMapper {
    int countByExample(TblMatchExample example);

    int deleteByExample(TblMatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblMatch record);

    int insertSelective(TblMatch record);

    List<TblMatch> selectByExampleWithBLOBs(TblMatchExample example);

    List<TblMatch> selectByExample(TblMatchExample example);

    TblMatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblMatch record, @Param("example") TblMatchExample example);

    int updateByExampleWithBLOBs(@Param("record") TblMatch record, @Param("example") TblMatchExample example);

    int updateByExample(@Param("record") TblMatch record, @Param("example") TblMatchExample example);

    int updateByPrimaryKeySelective(TblMatch record);

    int updateByPrimaryKeyWithBLOBs(TblMatch record);

    int updateByPrimaryKey(TblMatch record);
}
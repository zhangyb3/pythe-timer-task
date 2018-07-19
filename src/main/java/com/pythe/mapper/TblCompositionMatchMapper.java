package com.pythe.mapper;

import com.pythe.pojo.TblCompositionMatch;
import com.pythe.pojo.TblCompositionMatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCompositionMatchMapper {
    int countByExample(TblCompositionMatchExample example);

    int deleteByExample(TblCompositionMatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblCompositionMatch record);

    int insertSelective(TblCompositionMatch record);

    List<TblCompositionMatch> selectByExampleWithBLOBs(TblCompositionMatchExample example);

    List<TblCompositionMatch> selectByExample(TblCompositionMatchExample example);

    TblCompositionMatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblCompositionMatch record, @Param("example") TblCompositionMatchExample example);

    int updateByExampleWithBLOBs(@Param("record") TblCompositionMatch record, @Param("example") TblCompositionMatchExample example);

    int updateByExample(@Param("record") TblCompositionMatch record, @Param("example") TblCompositionMatchExample example);

    int updateByPrimaryKeySelective(TblCompositionMatch record);

    int updateByPrimaryKeyWithBLOBs(TblCompositionMatch record);

    int updateByPrimaryKey(TblCompositionMatch record);
}
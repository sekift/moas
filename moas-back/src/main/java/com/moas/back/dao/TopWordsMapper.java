package com.moas.back.dao;

import com.moas.back.model.TopWords;
import com.moas.back.model.TopWordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopWordsMapper {
    int countByExample(TopWordsExample example);

    int deleteByExample(TopWordsExample example);

    int deleteByPrimaryKey(Long wordid);

    int insert(TopWords record);

    int insertSelective(TopWords record);

    List<TopWords> selectByExample(TopWordsExample example);

    TopWords selectByPrimaryKey(Long wordid);

    int updateByExampleSelective(@Param("record") TopWords record, @Param("example") TopWordsExample example);

    int updateByExample(@Param("record") TopWords record, @Param("example") TopWordsExample example);

    int updateByPrimaryKeySelective(TopWords record);

    int updateByPrimaryKey(TopWords record);

    /**
     * 条件查询
     * @param record
     * @return
     */
    List<TopWords> search(TopWords record);

    /**
     * 热点词语查询
     * @return
     */
    List<TopWords> topWordsSearch();
}
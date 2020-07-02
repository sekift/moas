package com.moas.crawler.dao;

import com.moas.crawler.model.TopWords;
import com.moas.crawler.model.TopWordsExample;
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
}
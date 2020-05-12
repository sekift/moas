package com.moas.crawler.dao;

import com.moas.crawler.model.TopNews;
import com.moas.crawler.model.TopNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopNewsMapper {
    int countByExample(TopNewsExample example);

    int deleteByExample(TopNewsExample example);

    int deleteByPrimaryKey(Long topid);

    int insert(TopNews record);

    int insertSelective(TopNews record);

    List<TopNews> selectByExample(TopNewsExample example);

    TopNews selectByPrimaryKey(Long topid);

    int updateByExampleSelective(@Param("record") TopNews record, @Param("example") TopNewsExample example);

    int updateByExample(@Param("record") TopNews record, @Param("example") TopNewsExample example);

    int updateByPrimaryKeySelective(TopNews record);

    int updateByPrimaryKey(TopNews record);
}
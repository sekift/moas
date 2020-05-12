package com.moas.crawler.dao;

import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.model.TopNewsUrlExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopNewsUrlMapper {
    int countByExample(TopNewsUrlExample example);

    int deleteByExample(TopNewsUrlExample example);

    int deleteByPrimaryKey(Integer newsid);

    int insert(TopNewsUrl record);

    int insertSelective(TopNewsUrl record);

    List<TopNewsUrl> selectByExample(TopNewsUrlExample example);

    TopNewsUrl selectByPrimaryKey(Integer newsid);

    int updateByExampleSelective(@Param("record") TopNewsUrl record, @Param("example") TopNewsUrlExample example);

    int updateByExample(@Param("record") TopNewsUrl record, @Param("example") TopNewsUrlExample example);

    int updateByPrimaryKeySelective(TopNewsUrl record);

    int updateByPrimaryKey(TopNewsUrl record);
}
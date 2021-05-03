package com.moas.crawler.dao;

import com.moas.crawler.model.TopCoin;
import com.moas.crawler.model.TopCoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopCoinMapper {
    int countByExample(TopCoinExample example);

    int deleteByExample(TopCoinExample example);

    int deleteByPrimaryKey(Long coinid);

    int insert(TopCoin record);

    int insertSelective(TopCoin record);

    List<TopCoin> selectByExample(TopCoinExample example);

    TopCoin selectByPrimaryKey(Long coinid);

    int updateByExampleSelective(@Param("record") TopCoin record, @Param("example") TopCoinExample example);

    int updateByExample(@Param("record") TopCoin record, @Param("example") TopCoinExample example);

    int updateByPrimaryKeySelective(TopCoin record);

    int updateByPrimaryKey(TopCoin record);
}
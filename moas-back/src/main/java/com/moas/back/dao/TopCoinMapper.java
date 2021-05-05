package com.moas.back.dao;

import com.moas.back.model.TopCoin;
import com.moas.back.model.TopCoinExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.moas.back.model.TopNews;
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

    /**
     * 查询
     * @return
     */
    List<TopCoin> search(Integer greatSecond, Integer lessSecond);
}
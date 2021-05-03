package com.moas.crawler.service;

import com.moas.crawler.model.TopCoin;

import java.util.List;

public interface TopCoinService {

    /**
     * 新增信息
     * @param list
     * @return
     */
    void insert(List<TopCoin> list);
}

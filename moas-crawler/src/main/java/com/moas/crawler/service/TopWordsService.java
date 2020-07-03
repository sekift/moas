package com.moas.crawler.service;

import com.moas.crawler.model.TopWords;

public interface TopWordsService {
    /**
     * 新增信息
     * @param topWords
     * @return
     */
    void insert(TopWords topWords);
}

package com.moas.crawler.service;

import com.moas.crawler.model.TopNews;

import java.util.List;

public interface TopNewsService {

    /**
     * 新增信息
     * @param list
     * @return
     */
    void insert(List<TopNews> list);
}

package com.moas.crawler.service;

import com.moas.crawler.model.TopNewsUrl;

import java.util.List;

public interface TopNewsUrlService {

    /**
     * 获取热点链接信息
     * @return
     */
    public List<TopNewsUrl> selectByName(String newsName);

    public List<TopNewsUrl> selectAll();
}

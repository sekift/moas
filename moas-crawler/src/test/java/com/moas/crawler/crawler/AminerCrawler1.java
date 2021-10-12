package com.moas.crawler.crawler;

import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.strategy.NonPageParser;

import java.util.HashMap;
import java.util.Map;

public class AminerCrawler1 {

    public static void main(String args[]) {
        // 构造爬虫
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://nodeapi.aminer.cn/api/article/list/pagination")
                .setIfPost(false)
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        System.out.println(url + ": " + pageSource);
                        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
                        if (pageSourceMap == null || pageSourceMap.isEmpty() || pageSourceMap.get("data") == null) {
                            return;
                        }
                    }
                })
                .build();

        // 启动
        crawler.start(true);
    }

}

package com.moas.crawler.crawler;

import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.strategy.NonPageParser;

import java.util.List;
import java.util.Map;

public class WxbCrawler {

    public static void main(String args[]){
        // 构造爬虫
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://data.wxb.com/rank/article?baidu_cat=%E6%80%BB%E6%A6%9C&baidu_tag=&pageSize=50&page=1&type=2&order=")
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        //System.out.println(url + ": " + pageSource);
                        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
                        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("data") == null){
                            return;
                        }
                        List<Map<String,Object>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), List.class);
                        int index = 1;
                        for(Map<String,Object> e : listResult) {
                            System.out.println(index +" "+e.get("update_time")+" "  + e.get("like_num"));
                            if(index>=50){
                                break;
                            }
                            index ++;
                        }
                    }
                })
                .build();

        // 启动
        crawler.start(true);
    }

}

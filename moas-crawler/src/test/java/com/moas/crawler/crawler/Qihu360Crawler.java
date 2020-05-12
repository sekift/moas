package com.moas.crawler.crawler;

import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.strategy.NonPageParser;

import java.util.List;
import java.util.Map;

public class Qihu360Crawler {

    public static void main(String args[]){
        // 构造爬虫
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://trends.so.com/top/realtime")
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        System.out.println(url + ": " + pageSource);
                        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
                        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("data") == null){
                            return;
                        }
                        Map<String, Object> pageSourceData = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), Map.class);
                        if(pageSourceData == null || pageSourceData.isEmpty()||pageSourceData.get("result") == null){
                            return;
                        }
                        List<Map<String,String>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceData.get("result")), List.class);
                        int index = 1;
                        for(Map<String,String> e : listResult) {
                            System.out.println(index +" " + e.get("query")+" " + e.get("heat")+" " + e.get("update"));
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

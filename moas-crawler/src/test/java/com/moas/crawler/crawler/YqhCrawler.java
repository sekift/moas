package com.moas.crawler.crawler;

import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.strategy.NonPageParser;

import java.util.List;
import java.util.Map;

public class YqhCrawler {

    public static void main(String args[]){
        // 构造爬虫
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://query.aliyun.com/rest/content-platform.api.deliveryInfoSearch?idList=12198926&count=50&env=com&cna=69%2FRFKC3%2BkICARsuiDytsh%2FU&combo=true&pageSize=30&pageNum=1&sort=order_number&lang=zh")
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        //System.out.println(url + ": " + pageSource);
                        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
                        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("data") == null){
                            return;
                        }
                        Map<String,Object> pageSourceData = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), Map.class);

                        if(pageSourceData == null || pageSourceData.isEmpty()||pageSourceData.get("infoList") == null){
                            return;
                        }
                        List<Map<String,Object>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceData.get("infoList")), List.class);
                        int index = 1;
                        for(Map<String,Object> e : listResult) {
                            System.out.println(index +" "+e.get("title")+" "+e.get("link")+" "+e.get("image"));
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

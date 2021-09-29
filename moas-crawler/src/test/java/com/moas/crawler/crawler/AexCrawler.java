package com.moas.crawler.crawler;

import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.strategy.NonPageParser;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AexCrawler {

    private static final Map<String, String> headers = new HashMap<>();

    public static void main(String args[]){
        headers.put("Host", "www.aex.cool");
        headers.put("Referer", "https://www.aex.cool/");
        // 构造爬虫
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.aex.cool/v2/trade/marketQuotes.php")
                .setHeaderMap(headers)
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
                        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("data") == null){
                            return;
                        }
                        List<Map<String, Object>> pageSourceData = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), List.class);
                        if(pageSourceData == null || pageSourceData.isEmpty()){
                            return;
                        }
                        int index = 1;
                        for(Map<String, Object> e : pageSourceData) {
                            if(!e.get("market").equals("usdt")){
                                continue;
                            }

                            Map<String, String> tickerMap = null;
                            try {
                                tickerMap = JsonUtil.toBean(JsonUtil.toJson(e.get("ticker")), Map.class);
                            }catch (Exception e1){
                                continue;
                            }

                             if(Double.parseDouble(tickerMap.get("vol")) == 0.00){
                                continue;
                            }

                            String coinName = e.get("coin").toString();

                            System.out.println(index +" " + coinName + " " + e.get("ticker"));
                            if(index>=100){
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

package com.moas.crawler.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import com.xuxueli.crawler.parser.strategy.NonPageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AminerCrawler {

    public static void main(String args[]) {
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.aminer.cn/research_report/articlelist")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        Elements eles = pageVoElement.getElementsByTag("script");
//                        System.out.println(eles);
                        /*循环遍历script下面的JS变量*/
                        for (Element element : eles) {
                            /*取得JS变量数组*/
                            String data = element.data();
                            /*过滤variable为空的数据*/
                            if (data.contains("window.g_initialProps")) {
                                String[]  kvp = data.split(";");
                                for (String s : kvp) {
                                    if (s.contains("window.g_initialProps")) {
                                        String jsonString = s.replace("window.g_initialProps = ", "");
                                        Map jsonMap = JSONObject.parseObject(jsonString, Map.class);
                                        jsonMap = JSONObject.parseObject(jsonMap.get("report").toString(), Map.class);
                                        List<Map<String, Object>> list = JSONObject.parseObject(jsonMap.get("reportList").toString(), List.class);
                                        for(Map<String, Object> map : list){
                                            System.out.println(map);
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                })
                .build();

        // 启动
        crawler.start(true);
    }

}

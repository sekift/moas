package com.moas.crawler.crawler;

import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.parser.TopNewsParser;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.parser.PageParser;
import com.xuxueli.crawler.parser.strategy.NonPageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 微博热点
 *
 * @author sekift
 */
@Configuration
public class DynamicScheduleCrawler {

    @Autowired
    TopNewsParser parser;

    Map<String, String> header = new HashMap<String, String>();

    @PageSelect(cssQuery = "")
    public static class PageVo {
    }

    public void run(TopNewsUrl topNewsUrl){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls(topNewsUrl.getNewsurl())
                //.setWhiteUrlRegexs("https://gitee\\.com/xuxueli0323/projects\\?page=\\d+")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, PageVo pageVo) {
                        // 解析封装 PageVo 对象
                        parser.parser(topNewsUrl, pageVoElement);

                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

    public void runJson(TopNewsUrl topNewsUrl){
        header.put("Cookie", topNewsUrl.getCookie());
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls(topNewsUrl.getNewsurl())
                .setHeaderMap(header)
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        // 解析封装 PageVo 对象
                        parser.parser(topNewsUrl, pageSource);
                    }
                })
                .build();

        // 启动
        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }
}

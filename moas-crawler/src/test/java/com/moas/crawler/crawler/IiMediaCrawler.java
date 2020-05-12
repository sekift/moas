package com.moas.crawler.crawler;

import com.moas.crawler.crawler.DynamicScheduleCrawler;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class IiMediaCrawler {

    public static void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.iimedia.cn/")
                //.setWhiteUrlRegexs("https://gitee\\.com/xuxueli0323/projects\\?page=\\d+")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        // 解析封装 PageVo 对象


                        Elements elements = pageVoElement.getElementsByClass("childL");
                        //System.out.println("elements " + elements);

                        for(int i=0;i<elements.size();i++){
                            System.out.println(i+" "+elements.get(i).select("a").attr("title")+" "+elements.get(i).select("a").attr("href"));
                        }

                        List<Element> listEle = new ArrayList<Element>();


                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

}

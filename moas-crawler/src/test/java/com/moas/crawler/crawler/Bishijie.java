package com.moas.crawler.crawler;

import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Bishijie {

    public static void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.bishijie.com/kuaixun")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        // 解析封装 PageVo 对象
//                        System.out.println("html= " + html);
                        Elements eles = pageVoElement.getElementsByClass("content");
                        Elements elements = eles.select("a");
//                        System.out.println("elements " + elements);

                        for(int i=0;i<elements.size();i++){
                            Element e = elements.get(i);

                            if(e.hasText()&&e.hasAttr("href")
                                && e.attr("href").startsWith("/kuaixun")) {
                                String href = e.attr("href");
                                    System.out.println(i+" "+e.text()+" "+href);
                            }
                        }
                        List<Element> listEle = new ArrayList<>();
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

}

package com.moas.crawler.crawler;

import com.moas.crawler.util.StringUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SegmentCrawler {

    public static void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://segmentfault.com/hottest")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        // 解析封装 PageVo 对象

                        Elements elements = pageVoElement.getElementsByClass("news-item");
                        for(int i=0;i<elements.size();i++){
                            Element e = elements.get(i);
                            Elements eles = e.getElementsByClass("news-img");
                            System.out.println(i + " " + e.select("a").attr("href"));
                            String imgUrl = eles.attr("style");
                            if(!StringUtil.isEmpty(imgUrl)){
                                imgUrl = imgUrl.replace("background-image:url(","").replace(")","");
                            }else{
                                imgUrl = "";
                            }
                            System.out.println(i + " " + imgUrl);
                            Elements eles1 = e.getElementsByClass("news__item-title");
                            System.out.println(i + " " + eles1.text());
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

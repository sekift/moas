package com.moas.crawler.crawler;

import com.moas.crawler.crawler.DynamicScheduleCrawler;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Kr36Crawler {

    public static void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://36kr.com/newsflashes")
                //.setWhiteUrlRegexs("https://gitee\\.com/xuxueli0323/projects\\?page=\\d+")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        // 解析封装 PageVo 对象
                        //System.out.println("pageVoElement " + pageVoElement);

                        Elements elements = pageVoElement.getElementsByClass("main-right");
                        Elements elements1 = elements.select("a");

                        List<Element> listEle = new ArrayList<Element>();
                        for(int i = 0;i<elements1.size();i++){
                            Element e = elements1.get(i);
                            if(e.hasClass("item-title")||e.hasClass("link")){
                                listEle.add(e);
                            }
                        }

                        for(int i=0;i<listEle.size()-1;i++){
                            Element e1 = listEle.get(i);
                            Element e2 = listEle.get(i+1);
                            if(e1.hasClass("item-title")&&e2.hasClass("link")){
                                System.out.println(i+" "+listEle.get(i).attr("href")+" "+ listEle.get(i).text()
                                        +" "+listEle.get(i+1).attr("href"));

                            }else if(e1.hasClass("item-title")){
                                System.out.println(i+" "+listEle.get(i).attr("href")+" "+ listEle.get(i).text());
                            }
                        }

                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

}

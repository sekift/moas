package com.moas.crawler.crawler;

import com.moas.crawler.crawler.DynamicScheduleCrawler;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class BroadviewCrawler {

    public static void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("http://www.broadview.com.cn/book?tab=book&sort=new&page=0")
                //.setWhiteUrlRegexs("https://gitee\\.com/xuxueli0323/projects\\?page=\\d+")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        // 解析封装 PageVo 对象

                        Elements eles = pageVoElement.getElementsByClass("block-books");
                        Elements elements = eles.select("a");
                        System.out.println("eles " + eles);

                        for(int i=0;i<elements.size();i++){
                            Element e = elements.get(i);

                            if(e.hasText()&&e.hasAttr("href")) {
                                String href = e.attr("href");
                                if(href.contains("details")&&e.text().length()>8) {
                                    //System.out.println(i + " " + e);//.
                                    //System.out.println(i+" "+e.text()+" "+href);
                                }
                            }
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

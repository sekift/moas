package com.moas.crawler.crawler;

import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeiboCrawler {

    public static void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("http://www.cbst.com.cn/news/index/id/24/p/1.html")
                //.setWhiteUrlRegexs("https://gitee\\.com/xuxueli0323/projects\\?page=\\d+")
                .setAllowSpread(false)
                .setThreadCount(1)
                .setPageParser(new PageParser<DynamicScheduleCrawler.PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, DynamicScheduleCrawler.PageVo pageVo) {
                        // 解析封装 PageVo 对象
//                        System.out.println(pageVoElement);

                        Elements eles = pageVoElement.getElementsByClass("new-list");
                        System.out.println(eles);


                        Elements elements = eles.select("a");
                        for(int i=0;i<elements.size();i++){
                            Element e = elements.get(i);

                            if(e.hasText()&&e.hasAttr("href")) {
                                String href = e.attr("href");
                                if(href.contains("details")&&!e.text().startsWith("查看详情")) {
                                    System.out.println(i+" "+e.text()+" "+href);
                                }
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

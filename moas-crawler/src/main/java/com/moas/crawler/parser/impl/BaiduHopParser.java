package com.moas.crawler.parser.impl;

import com.moas.crawler.common.Consts;
import com.moas.crawler.model.TopNews;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.util.MD5Util;
import com.moas.crawler.util.SnowflakeIdWorker;
import com.moas.crawler.util.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class BaiduHopParser{
    private static Logger logger = LoggerFactory.getLogger(BaiduHopParser.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element){
        List<TopNews> list = new ArrayList<TopNews>();
        System.out.println(topNewsUrl.getNewsname()+"，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId()+"，topNewsUrl="+topNewsUrl);
        //System.out.println("topNewsUrl="+topNewsUrl);
        Elements elements = element.getElementsByTag("tr");
        //System.out.println(elements);

        TopNews topNews = null;
        for(Element e : elements) {
            String content =e.getElementsByClass("list-title").text();
            if(StringUtil.isEmpty(content)){
                continue;
            }
            topNews = new TopNews();

            String sortindexStr = e.getElementsByClass("num-top").text();
            if(StringUtil.isEmpty(sortindexStr)){
                sortindexStr = e.getElementsByClass("num-normal").text();
            }
            if(StringUtil.isEmpty(sortindexStr)){
                sortindexStr = "1";
            }

            String toprankStr = e.getElementsByClass("icon-rise").text();
            if(StringUtil.isEmpty(toprankStr)) {
                toprankStr = e.getElementsByClass("icon-fall").text();
            }
            if(StringUtil.isEmpty(toprankStr)){
                toprankStr = Consts.TOPRANK_DEFAULT;
            }

            String linkurl = e.getElementsByClass("list-title").select("a").attr("href");

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content+topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(Integer.valueOf(sortindexStr));
            topNews.setToprank(Integer.valueOf(toprankStr));
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(new Date());

            String notestring ="";
            Elements iconNewSpan = e.getElementsByClass("keyword").select("span");
            if(iconNewSpan != null && iconNewSpan.toString().contains("icon-new")){
                notestring = "热";
            }
            topNews.setNotestring(notestring);
            topNews.setRemark("");
            list.add(topNews);
        }
        return list;
    }
}

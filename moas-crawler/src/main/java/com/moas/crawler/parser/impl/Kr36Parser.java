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
import java.util.Random;

@Configuration
public class Kr36Parser {
    private static Logger logger = LoggerFactory.getLogger(Kr36Parser.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element){
        List<TopNews> list = new ArrayList<TopNews>();
        System.out.println(topNewsUrl.getNewsname()+"，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId()+"，topNewsUrl="+topNewsUrl);
        //System.out.println("topNewsUrl="+topNewsUrl);

        Elements elements = element.getElementsByClass("main-right");
        Elements elements1 = elements.select("a");

        List<Element> listEle = new ArrayList<Element>();
        for(int i = 0;i<elements1.size();i++){
            Element e = elements1.get(i);
            if(e.hasClass("item-title")||e.hasClass("link")){
                listEle.add(e);
            }
        }

        TopNews topNews = null;
        int j = 0;
        for(int i=0;i<listEle.size()-1;i++){
            Element e1 = listEle.get(i);
            Element e2 = listEle.get(i+1);
            String content = "";
            String linkurl = "";
            String remark = "";
            if(e1.hasClass("item-title")&&e2.hasClass("link")){
                content = listEle.get(i).text();
                linkurl = listEle.get(i+1).attr("href");
                remark = Consts.KR36_DOMAIN + listEle.get(i).attr("href");
                j++;
            }else if(e1.hasClass("item-title")){
                content = listEle.get(i).text();
                linkurl = Consts.KR36_DOMAIN + listEle.get(i).attr("href");
                remark = "";
                j++;
            }

            if(StringUtil.isEmpty(content)){
                continue;
            }
            topNews = new TopNews();

            int toprank = Consts.KR36_TOPRANK_DEFAULT - j * Consts.KR36_RANGE - new Random().nextInt(Consts.KR36_RANGE);
            //System.out.println("toprank "+toprank);

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content+topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(j);
            topNews.setToprank(toprank);
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(new Date());

            String notestring ="";
            topNews.setNotestring(notestring);
            topNews.setRemark(remark);
            list.add(topNews);
        }
        return list;
    }
}

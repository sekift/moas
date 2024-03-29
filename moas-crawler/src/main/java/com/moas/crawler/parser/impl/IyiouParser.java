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
public class IyiouParser {
    private static Logger logger = LoggerFactory.getLogger(IyiouParser.class);

    private static final String URL = "https://www.iyiou.com";

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element) {
        List<TopNews> list = new ArrayList<>();
        System.out.println(topNewsUrl.getNewsname() + "，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId() + "，topNewsUrl=" + topNewsUrl);
        //System.out.println("topNewsUrl="+topNewsUrl);

        Elements eles = element.getElementsByClass("eo-line-clamp-2");
        Elements elements = eles.select("a");

        TopNews topNews = null;
        int j = 1;
        for (int i = 0; i < elements.size(); i++) {
            if (i % 2 != 0) {
                continue;
            }
            Element e = elements.get(i);
            String content = e.text();
            String linkurl = e.attr("href");
            if (StringUtil.isEmpty(content) || StringUtil.isEmpty(linkurl)) {
                continue;
            }
            topNews = new TopNews();
            int toprank = Consts.KR36_TOPRANK_DEFAULT - j * Consts.KR36_RANGE - new Random().nextInt(Consts.KR36_RANGE);

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content + topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(j);
            topNews.setToprank(toprank);
            topNews.setContent(content);
            topNews.setLinkurl(URL + linkurl);
            topNews.setPosttime(new Date());

            topNews.setNotestring("");
            topNews.setRemark("");
            j++;

            list.add(topNews);

        }
        return list;
    }
}

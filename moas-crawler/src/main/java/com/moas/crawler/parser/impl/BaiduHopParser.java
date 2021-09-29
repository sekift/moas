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
public class BaiduHopParser {
    private static Logger logger = LoggerFactory.getLogger(BaiduHopParser.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element) {
        List<TopNews> list = new ArrayList<>();
        System.out.println(topNewsUrl.getNewsname() + "，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId() + "，topNewsUrl=" + topNewsUrl);
        Elements elements = element.getElementsByClass("category-wrap_iQLoo horizontal_1eKyQ");
        System.out.println(elements);

        TopNews topNews = null;
        for (Element e : elements) {
            String content = e.getElementsByClass("c-single-text-ellipsis").text();
            if (StringUtil.isEmpty(content)) {
                continue;
            }
            topNews = new TopNews();

            String sortindexStr = e.getElementsByClass("index_1Ew5p").text();
            if (StringUtil.isEmpty(sortindexStr)) {
                sortindexStr = "1";
            }

            String toprankStr = e.getElementsByClass("hot-index_1Bl1a").text();
            if (StringUtil.isEmpty(toprankStr)) {
                toprankStr = Consts.TOPRANK_DEFAULT;
            }

            String imageurl = e.getElementsByClass("img-wrapper_29V76")
                    .select("img").attr("src");
            String linkurl = e.getElementsByClass("category-wrap_iQLoo horizontal_1eKyQ")
                    .select("a").attr("href");

            topNews.setTopid(snowflakeIdWorker.nextId());
            topNews.setMd5(MD5Util.md5(content + topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setImageurl(imageurl);
            topNews.setSortindex(Integer.valueOf(sortindexStr));
            topNews.setToprank(Integer.valueOf(toprankStr));
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(new Date());

            String notestring = "";
            Elements iconNewSpan = e.getElementsByClass("c-text c-text-hot_3ZhI9 hot-tag_1G080");
            if (iconNewSpan != null) {
                notestring = "热";
            }
            topNews.setNotestring(notestring);
            topNews.setRemark("");
            list.add(topNews);
        }
        return list;
    }
}

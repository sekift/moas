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
public class CbstParser {
    private static Logger logger = LoggerFactory.getLogger(CbstParser.class);
    private static final String URL = "http://www.cbst.com.cn";

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element) {
        List<TopNews> list = new ArrayList<>();
        System.out.println(topNewsUrl.getNewsname() + "，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId() + "，topNewsUrl=" + topNewsUrl);
        Elements elements = element.getElementsByClass("ny-box").select("a");
        System.out.println(elements);

        TopNews topNews = null;
        for (Element e : elements) {
            String content = e.text();
            String linkurl = e.attr("href");
            if (StringUtil.isEmpty(content) || content.startsWith("查看详情") || !linkurl.contains("details")) {
                continue;
            }
            topNews = new TopNews();

            String sortindexStr = "1";

            String toprankStr = Consts.TOPRANK_DEFAULT;
            topNews.setTopid(snowflakeIdWorker.nextId());
            topNews.setMd5(MD5Util.md5(content + topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(Integer.valueOf(sortindexStr));
            topNews.setToprank(Integer.valueOf(toprankStr));
            topNews.setContent(content);
            topNews.setLinkurl(URL + linkurl);
            topNews.setPosttime(new Date());

            topNews.setNotestring("");
            topNews.setRemark("");
            list.add(topNews);
        }
        return list;
    }
}

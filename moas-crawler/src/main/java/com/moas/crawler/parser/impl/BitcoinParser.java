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
public class BitcoinParser {
    private static Logger logger = LoggerFactory.getLogger(BitcoinParser.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element) {
        List<TopNews> list = new ArrayList<>();
        System.out.println(topNewsUrl.getNewsname() + "，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId() + "，topNewsUrl=" + topNewsUrl);
//        System.out.println("topNewsUrl="+topNewsUrl);

        Elements eles = element.getElementsByClass("title");
        Elements elements = eles.select("a");
        TopNews topNews = null;
        int j = 1;
        for (int i = 0; i < elements.size(); i++) {
            Element e = elements.get(i);
//            System.out.println("e="+e);

            if (e.hasText() && e.hasAttr("href")) {
                String href = e.attr("href");
                String content = e.text();
                String linkurl = Consts.BITCOIN_DOMAIN + href;
                if (StringUtil.isEmpty(content) || StringUtil.isEmpty(linkurl)) {
                    continue;
                }
                topNews = new TopNews();
                int toprank = Consts.KR36_TOPRANK_DEFAULT - j * Consts.CTO15_RANGE - new Random().nextInt(Consts.CTO15_RANGE);

                topNews.setTopid(snowflakeIdWorker.nextId());//
                topNews.setMd5(MD5Util.md5(content + topNewsUrl.getNewsid(), "utf-8"));
                topNews.setSourceid(topNewsUrl.getNewsid());
                topNews.setSource(topNewsUrl.getNewsname());

                topNews.setSortindex(j);
                topNews.setToprank(toprank);
                topNews.setContent(content);
                topNews.setLinkurl(linkurl);
                topNews.setPosttime(new Date());

                String notestring = "";
                topNews.setNotestring(notestring);
                topNews.setRemark("");
                j++;

                list.add(topNews);

            }
        }
        return list;
    }
}

package com.moas.crawler.parser.impl;

import com.alibaba.fastjson.JSONObject;
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
import java.util.Map;

@Configuration
public class AminerParser {
    private static Logger logger = LoggerFactory.getLogger(AminerParser.class);

    private static final String URL = "https://www.aminer.cn/research_report/";

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element) {
        List<TopNews> list = new ArrayList<>();
        System.out.println(topNewsUrl.getNewsname() + "，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId() + "，topNewsUrl=" + topNewsUrl);

        List<Map<String, Object>> resultList = new ArrayList<>();
        Elements eles = element.getElementsByTag("script");
        for (Element ele : eles) {
            /*取得JS变量数组*/
            String data = element.data();
            /*过滤variable为空的数据*/
            if (data.contains("window.g_initialProps")) {
                String[]  kvp = data.split(";");
                for (String s : kvp) {
                    if (s.contains("window.g_initialProps")) {
                        String jsonString = s.replace("window.g_initialProps = ", "");
                        Map jsonMap = JSONObject.parseObject(jsonString, Map.class);
                        jsonMap = JSONObject.parseObject(jsonMap.get("report").toString(), Map.class);
                        resultList = JSONObject.parseObject(jsonMap.get("reportList").toString(), List.class);
                        break;
                    }
                }
            }
        }

        TopNews topNews = null;
        for (Map<String, Object> map : resultList) {
            topNews = new TopNews();

            String content = map.get("title").toString();
            String sortindexStr = map.get("like").toString();
            String toprankStr = map.get("view").toString();
            String imageurl = map.get("image").toString();
            String linkurl = URL + map.get("_id").toString();

            topNews.setTopid(snowflakeIdWorker.nextId());
            topNews.setMd5(MD5Util.md5(content + topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(map.get("author").toString());

            topNews.setImageurl(imageurl);
            topNews.setSortindex(Integer.valueOf(sortindexStr));
            topNews.setToprank(Integer.valueOf(toprankStr));
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(new Date());

            topNews.setNotestring("");
            topNews.setRemark("");
            list.add(topNews);
        }
        return list;
    }
}

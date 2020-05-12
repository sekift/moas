package com.moas.crawler.parser.impl;

import com.moas.crawler.common.Consts;
import com.moas.crawler.model.TopNews;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.util.JsonUtil;
import com.moas.crawler.util.MD5Util;
import com.moas.crawler.util.SnowflakeIdWorker;
import com.moas.crawler.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.*;

/**
 * https://yqh.aliyun.com/ 云栖号
 */
@Configuration
public class YqhParser {
    private static Logger logger = LoggerFactory.getLogger(YqhParser.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, String pageSource){
        List<TopNews> list = new ArrayList<TopNews>();
        System.out.println(topNewsUrl.getNewsname()+"，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + "，线程id：" + Thread.currentThread().getId()+"，topNewsUrl="+topNewsUrl);
        //System.out.println();
        //System.out.println(pageSource);

        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("data") == null){
            return list;
        }
        Map<String,Object> pageSourceData = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), Map.class);

        if(pageSourceData == null || pageSourceData.isEmpty()||pageSourceData.get("infoList") == null){
            return list;
        }
        List<Map<String,Object>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceData.get("infoList")), List.class);
        int index = 1;
        TopNews topNews = null;
        for(Map<String,Object> e : listResult) {
            String content = e.get("title").toString();
            if(StringUtil.isEmpty(content)){
                continue;
            }
            topNews = new TopNews();

            int toprank = Consts.KR36_TOPRANK_DEFAULT - index * Consts.KR36_RANGE - new Random().nextInt(Consts.KR36_RANGE);

            String linkurl = e.get("link").toString();
            String imageurl = e.get("image").toString();

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content, "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setImageurl(imageurl);
            topNews.setSortindex(index);
            topNews.setToprank(toprank);
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(new Date());

            topNews.setNotestring("");
            topNews.setRemark("");
            list.add(topNews);
            if(index>=50){
                break;
            }
            index ++;
        }
        return list;
    }
}

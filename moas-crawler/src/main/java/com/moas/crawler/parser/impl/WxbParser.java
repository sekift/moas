package com.moas.crawler.parser.impl;

import com.moas.crawler.model.TopNews;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://data.wxb.com/ 微小宝
 */
@Configuration
public class WxbParser {
    private static Logger logger = LoggerFactory.getLogger(WxbParser.class);

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
        List<Map<String,Object>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), List.class);
        int index = 1;
        TopNews topNews = null;
        for(Map<String,Object> e : listResult) {
            String content = e.get("title").toString();
            if(StringUtil.isEmpty(content)){
                continue;
            }
            topNews = new TopNews();

            int toprank = Integer.valueOf(e.get("like_num").toString());

            //http://www.so.com/s?ie=utf-8&src=zhishu&q=%E5%BC%A0%E6%96%87%E5%AE%8F%20%E5%85%B3%E7%B3%BB%E5%B7%AE%E7%9A%84%E4%BA%BA
            String linkurl = e.get("url").toString();

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content, "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(index);
            topNews.setToprank(toprank);
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(DateUtil.convertStrToDate(e.get("update_time").toString(), DateUtil.DATETIME_FORMAT));

            String notestring ="";
            if(Integer.valueOf(e.get("is_original").toString()) == 1){
                notestring = "热";
            }
            topNews.setNotestring(notestring);
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

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration
public class Qihu360Parser {
    private static Logger logger = LoggerFactory.getLogger(Qihu360Parser.class);

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
        Map<String, Object> pageSourceData = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), Map.class);
        if(pageSourceData == null || pageSourceData.isEmpty()||pageSourceData.get("result") == null){
            return list;
        }
        List<Map<String,String>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceData.get("result")), List.class);
        int index = 1;
        TopNews topNews = null;
        for(Map<String,String> e : listResult) {
            //System.out.println(index +" " + e.get("query")+" " + e.get("heat")+" " + e.get("update"));

            String content = e.get("query");
            if(StringUtil.isEmpty(content)){
                continue;
            }
            topNews = new TopNews();

            String toprankStr = e.get("heat");
            if(StringUtil.isEmpty(toprankStr)){
                toprankStr = Consts.QIHU_TOPRANK_DEFAULT;
            }

            //http://www.so.com/s?ie=utf-8&src=zhishu&q=%E5%BC%A0%E6%96%87%E5%AE%8F%20%E5%85%B3%E7%B3%BB%E5%B7%AE%E7%9A%84%E4%BA%BA
            String linkurl = Consts.QIHU_DOMAIN + content;

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content+topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(index);
            topNews.setToprank(Integer.valueOf(toprankStr));
            topNews.setContent(content);
            topNews.setLinkurl(linkurl);
            topNews.setPosttime(new Date());

            String notestring ="";
            if("1".equals(e.get("update"))){
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

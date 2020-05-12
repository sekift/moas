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
public class WeiboRealtimeHopParser{
    private static Logger logger = LoggerFactory.getLogger(WeiboRealtimeHopParser.class);

    /**
     CREATE TABLE `top_news` (
     `topid` bigint(64) NOT NULL COMMENT 'topid',
     `md5` varchar(128) DEFAULT '' COMMENT '根据content等计算的md5，用于去重',
     `sortindex` int(11) DEFAULT '1' COMMENT '排行榜的序号',
     `content` varchar(1023) NOT NULL COMMENT '具体热榜内容',
     `toprank` int(11) DEFAULT '0' COMMENT '搜索指数，热度',
     `linkurl` varchar(511) DEFAULT NULL COMMENT '热榜链接',
     `sourceid` int(11) DEFAULT NULL COMMENT '热榜来源id',
     `source` varchar(255) DEFAULT NULL COMMENT '热榜来源',

     `posttime` datetime DEFAULT NULL COMMENT '热榜提交时间',
     `createtime` datetime DEFAULT NULL COMMENT '爬取时间',
     `updatetime` datetime DEFAULT NULL COMMENT '更新时间',

     `status` tinyint(2) DEFAULT '1' COMMENT '状态，0 删除 1 正常',
     `visits` int(11) DEFAULT '0' COMMENT '访问次数',
     `noteint` int(11) DEFAULT NULL COMMENT '备用1',
     `notestring` varchar(511) DEFAULT NULL COMMENT '备用2',
     `remark` varchar(255) DEFAULT NULL COMMENT '备用3',
     PRIMARY KEY (`topid`),
     UNIQUE KEY `md5_idx` (`md5`) USING BTREE COMMENT 'MD5索引'
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     * @param topNewsUrl
     * @param element
     * @return
     */

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element){
        List<TopNews> list = new ArrayList<TopNews>();
        logger.info(topNewsUrl.getNewsname()+"，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + " 线程id：" + Thread.currentThread().getId()+"，topNewsUrl="+topNewsUrl);
        //System.out.println("topNewsUrl="+topNewsUrl);

        Elements elements = element.getElementsByTag("tr");
        //System.out.println(elements);
        TopNews topNews = null;
        for(Element e : elements) {
            String contentStr =  e.getElementsByClass("td-02").text();
            String[] contentArr = contentStr.split(" ");
            String content = "";
            for(int i=0;i<contentArr.length-1;i++){
                content = content+" "+contentArr[i];
            }

            if(StringUtil.isEmpty(content)){
                continue;
            }
            topNews = new TopNews();

            String sortindexStr = e.getElementsByClass("td-01").text();
            if(StringUtil.isEmpty(sortindexStr)){
                sortindexStr = "1";
            }

            String toprankStr = "";
            try{
                if(contentArr.length>1) {
                    toprankStr = contentArr[contentArr.length - 1];
                }
            }catch(Exception e1){
            }
            if(StringUtil.isEmpty(toprankStr)){
                toprankStr = Consts.TOPRANK_DEFAULT;
            }

            String linkurl = e.getElementsByClass("td-02").select("a").attr("href");
            if(StringUtil.isEmpty(linkurl)|| linkurl.contains("javascript")){
                linkurl = e.getElementsByClass("td-02").select("a").attr("href_to");
            }

            topNews.setTopid(snowflakeIdWorker.nextId());//
            topNews.setMd5(MD5Util.md5(content+topNewsUrl.getNewsid(), "utf-8"));
            topNews.setSourceid(topNewsUrl.getNewsid());
            topNews.setSource(topNewsUrl.getNewsname());

            topNews.setSortindex(Integer.valueOf(sortindexStr));
            topNews.setToprank(Integer.valueOf(toprankStr));
            topNews.setContent(content);
            topNews.setLinkurl(Consts.S_WEIBO_DOMAIN + linkurl);

            topNews.setPosttime(new Date());
            String notestring = e.getElementsByClass("td-03").text();
            topNews.setNotestring(notestring);
            topNews.setRemark("");

            list.add(topNews);
        }
        return list;
    }
}

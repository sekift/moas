package com.moas.crawler.service.impl;

import com.moas.crawler.dao.TopNewsMapper;
import com.moas.crawler.model.TopNews;
import com.moas.crawler.model.TopNewsExample;
import com.moas.crawler.service.TopNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopNewsServiceImpl implements TopNewsService {
    private static Logger logger = LoggerFactory.getLogger(TopNewsServiceImpl.class);

    @Autowired
    private TopNewsMapper topNewsMapper;

    private String[] filterDomain = {"www.thepaper.cn","www.ithome.com"};

    @Override
    public void insert(List<TopNews> list) {
        List<TopNews> listUpdate = new ArrayList<TopNews>();

        try {
            for (TopNews topNews : list) {
                // 过滤不要的域名地址
                boolean flag = false;
                for(String filterName : filterDomain){
                    if(topNews.getLinkurl().contains(filterName)){
                        flag = true;
                        break;
                    }
                }

                if(flag){
                    continue;
                }

                //先查
                TopNews topNews1 = selectByExample(topNews.getMd5());
                if(topNews1 == null){
                    topNews.setCreatetime(new Date());
                    topNews.setUpdatetime(new Date());

                    topNews.setVisits(1);
                    topNews.setStatus(Byte.valueOf("1"));
                    topNews.setNoteint(0);

                    if(topNews.getImageurl() == null){
                        topNews.setImageurl("");
                    }
                    topNewsMapper.insert(topNews);
                }else{
                    topNews.setTopid(topNews1.getTopid());

                    topNews.setPosttime(topNews1.getPosttime());
                    topNews.setCreatetime(topNews1.getCreatetime());
                    topNews.setUpdatetime(new Date());
                    topNews.setImageurl(topNews1.getImageurl());

                    topNews.setStatus(topNews1.getStatus());
                    topNews.setVisits(topNews1.getVisits());
                    topNews.setNoteint(topNews1.getNoteint());
                    topNews.setNotestring(topNews1.getNotestring());
                    topNews.setRemark(topNews1.getRemark());
                    topNewsMapper.updateByPrimaryKey(topNews);
                }
            }
        }catch(Exception e){
            logger.error("TopNewsService插入数据出错了，"+e);
        }
    }

    public TopNews selectByExample(String md5){
        TopNews topNews = null;
        TopNewsExample topNewsExample = new TopNewsExample();
        topNewsExample.createCriteria().andMd5EqualTo(md5);
        List<TopNews> list = topNewsMapper.selectByExample(topNewsExample);
        if(list != null && !list.isEmpty()){
            topNews = list.get(0);
        }
        return topNews;
    }
}

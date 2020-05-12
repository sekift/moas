package com.moas.crawler.service.impl;

import com.moas.crawler.dao.TopNewsUrlMapper;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.model.TopNewsUrlExample;
import com.moas.crawler.service.TopNewsUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopNewsUrlServiceImpl implements TopNewsUrlService {

    @Autowired
    private TopNewsUrlMapper topNewsUrlMapper;

    @Override
    public List<TopNewsUrl> selectByName(String newsName){
        TopNewsUrlExample example = new TopNewsUrlExample();
        example.createCriteria().andStatusEqualTo(Byte.valueOf("1"))
                .andNewsnameEqualTo(newsName);
        List<TopNewsUrl> list = topNewsUrlMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<TopNewsUrl> selectAll(){
        TopNewsUrlExample example = new TopNewsUrlExample();
        example.createCriteria().andStatusEqualTo(Byte.valueOf("1"));
        List<TopNewsUrl> list = topNewsUrlMapper.selectByExample(example);
        return list;
    }
}

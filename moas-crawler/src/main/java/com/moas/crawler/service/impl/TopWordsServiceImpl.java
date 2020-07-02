package com.moas.crawler.service.impl;

import com.moas.crawler.dao.TopWordsMapper;
import com.moas.crawler.model.TopWords;
import com.moas.crawler.service.TopWordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopWordsServiceImpl implements TopWordsService {
    private static Logger logger = LoggerFactory.getLogger(TopWordsServiceImpl.class);

    @Autowired
    private TopWordsMapper topWordsMapper;

    @Override
    public void insert(TopWords topWords){
        try {
            topWordsMapper.insert(topWords);
        }catch (Exception e){
            logger.error("插入分词错误了，",e);
        }
    }
}

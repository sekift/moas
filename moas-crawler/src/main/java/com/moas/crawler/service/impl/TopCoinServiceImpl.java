package com.moas.crawler.service.impl;

import com.moas.crawler.dao.TopCoinMapper;
import com.moas.crawler.model.TopCoin;
import com.moas.crawler.service.TopCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopCoinServiceImpl implements TopCoinService {
    private static Logger logger = LoggerFactory.getLogger(TopCoinServiceImpl.class);

    @Autowired
    private TopCoinMapper topCoinMapper;

    @Override
    public void insert(List<TopCoin> list) {
        try {
            for (TopCoin topCoin : list) {
                topCoinMapper.insert(topCoin);
            }
        }catch(Exception e){
            logger.error("TopCoinService插入数据出错了，"+e);
        }
    }
}

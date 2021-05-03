package com.moas.crawler.parser.impl;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.moas.crawler.model.TopCoin;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.util.JsonUtil;
import com.moas.crawler.util.SnowflakeIdWorker;
import com.moas.crawler.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration
public class AexParser {
    private static Logger logger = LoggerFactory.getLogger(AexParser.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<TopCoin> parser(TopNewsUrl topNewsUrl, String pageSource){
        List<TopCoin> list = new ArrayList<>();
        System.out.println(topNewsUrl.getNewsname()+"，"
                + LocalDateTime.now() + "，线程名称：" + Thread.currentThread().getName()
                + "，线程id：" + Thread.currentThread().getId()+"，topNewsUrl="+topNewsUrl);
        //System.out.println();
//        System.out.println(pageSource);

        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("data") == null){
            return list;
        }
        List<Map<String, Object>> pageSourceData = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("data")), List.class);
        if(pageSourceData == null || pageSourceData.isEmpty()){
            return list;
        }
        int index = 1;
        TopCoin topCoin = null;
        for(Map<String, Object> e : pageSourceData) {

            if(!e.get("market").equals("cnc")){
                continue;
            }

            Map<String, String> tickerMap = null;
            try {
                tickerMap = JsonUtil.toBean(JsonUtil.toJson(e.get("ticker")), Map.class);
            }catch (Exception e1){
                continue;
            }

            if(StringUtil.isEmpty(tickerMap.get("vol"))||StringUtil.isEmpty(tickerMap.get("high"))
            ||StringUtil.isEmpty(tickerMap.get("low"))||StringUtil.isEmpty(tickerMap.get("last24"))
            ||StringUtil.isEmpty(tickerMap.get("last"))||StringUtil.isEmpty(tickerMap.get("money"))
            ||StringUtil.isEmpty(tickerMap.get("buy"))||StringUtil.isEmpty(tickerMap.get("sell"))
            ||StringUtil.isEmpty(tickerMap.get("range"))){
                continue;
            }
            if(Double.parseDouble(tickerMap.get("vol")) == 0.00){
                continue;
            }
            topCoin = new TopCoin();

            String coinName = e.get("coin").toString();
            System.out.println(tickerMap);
            BigDecimal vol = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("vol")));
            BigDecimal high = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("high")));
            BigDecimal low = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("low")));
            BigDecimal lastDay = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("last24")));
            BigDecimal last = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("last")));
            BigDecimal money = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("money")));
            BigDecimal buy = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("buy")));
            BigDecimal sell = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("sell")));
            BigDecimal range = BigDecimal.valueOf(Double.parseDouble(tickerMap.get("range")));

            topCoin.setCoinid(snowflakeIdWorker.nextId());
            topCoin.setCoinName(coinName);
            topCoin.setVol(vol);
            topCoin.setHigh(high);
            topCoin.setLow(low);
            topCoin.setLastDay(lastDay);
            topCoin.setLast(last);
            topCoin.setMoney(money);
            topCoin.setBuy(buy);
            topCoin.setSell(sell);
            topCoin.setCoinRange(range);
            topCoin.setCreateTime(new Date());

            list.add(topCoin);

            if(index>=100){
                break;
            }
            index ++;
        }
        return list;
    }
}

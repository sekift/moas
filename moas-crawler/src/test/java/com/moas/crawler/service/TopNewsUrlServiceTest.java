package com.moas.crawler.service;

import com.moas.crawler.service.TopNewsUrlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopNewsUrlServiceTest {

    @Autowired
    private TopNewsUrlService topNewsUrlService;

    @Test
    public void testSelectByName(){
        topNewsUrlService.selectByName("微博热搜榜");
    }


}

package com.moas.crawler.service;

import com.moas.crawler.model.TopNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopNewsServiceTest {

    @Autowired
    private TopNewsService topNewsService;

    @Test
    public void testInsert(){
        TopNews topNews = new TopNews();
        topNews.setTopid(2L);
        topNews.setContent("b");
        List<TopNews> list = new ArrayList<TopNews>();
        topNewsService.insert(list);
    }


}

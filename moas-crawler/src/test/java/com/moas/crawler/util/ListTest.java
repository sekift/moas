package com.moas.crawler.util;

import com.moas.crawler.model.TopNews;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    private String[] filterDomain = {"a","c","d","e"};

    public void insert() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("fff");

        for (String topNews : list) {
            // 过滤不要的域名地址
            boolean flag = false;
            for (String filterName : filterDomain) {
                if (topNews.contains(filterName)) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }

            System.out.println(topNews);
        }

    }

    public static void main(String args[]){
        ListTest test = new ListTest();
        test.insert();
    }
}

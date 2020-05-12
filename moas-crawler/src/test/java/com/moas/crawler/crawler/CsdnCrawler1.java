package com.moas.crawler.crawler;

import com.moas.crawler.util.JsonUtil;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.strategy.NonPageParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsdnCrawler1 {

    public static void main(String args[]){

        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        headers.put("Accept-Encoding","gzip, deflate, br");
//        headers.put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//        headers.put("Cache-Control","no-cache");
//        headers.put("Connection","keep-alive");
        headers.put("Cookie","uuid_tt_dd=10_4560345260-1548434018612-368028; dc_session_id=10_1548434018612.516935; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1587452561,1587452827,1587452842,1587454949; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC!6525*1*10_4560345260-1548434018612-368028; smidV2=20190126003343051177f7a4e3e81e090579ca4e3ede0f0020ea267d24aa870; __gads=ID=cc66e0d47b2df06b:T=1582558551:S=ALNI_MZRJs1shdVyzby81bxU7qZyW4pAYQ; c-login-auto=19; SESSION=c6757725-151b-4f83-9722-b369a86f2b34; aliyun_webUmidToken=T6118E372C448464D88EBD4702CABCF4B76D0685F785B72C0C08752C3CA; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1587455616; c_ref=https%3A//www.baidu.com/link; dc_sid=607959adc201267dcd83d42a6a4aa10a; TY_SESSION_ID=4295a6f0-cffa-4769-9fa4-af6b387c68f3; c_first_ref=https%3A//www.baidu.com/link; c_first_page=https%3A//www.csdn.net/; dc_tos=q94ol9; announcement=%257B%2522isLogin%2522%253Afalse%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblog.csdn.net%252Fblogdevteam%252Farticle%252Fdetails%252F105203745%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; c_adb=1; c-toolbar-writeguide=1; utm_source=distribute.pc_feed.none-task-blog-alirecmd-1");
//        headers.put("Host","www.csdn.net");
//        headers.put("Pragma","no-cache");
//        headers.put("TE","Trailers");
//        headers.put("Upgrade-Insecure-Requests","1");
//        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0");

        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.csdn.net/api/articles?type=new&category=home")
                .setHeaderMap(headers)
                .setPageParser(new NonPageParser() {
                    @Override
                    public void parse(String url, String pageSource) {
                        System.out.println(url + ": " + pageSource);
                        Map<String, Object> pageSourceMap = JsonUtil.toBean(pageSource, Map.class);
                        if(pageSourceMap == null || pageSourceMap.isEmpty()||pageSourceMap.get("articles") == null){
                            return;
                        }
                        List<Map<String,String>> listResult = JsonUtil.toBean(JsonUtil.toJson(pageSourceMap.get("articles")), List.class);
                        int index = 1;
                        for(Map<String,String> e : listResult) {
                            System.out.println(index +" " + e);
                            if(index>=50){
                                break;
                            }
                            index ++;
                        }
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

}

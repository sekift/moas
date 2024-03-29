package com.moas.crawler.parser.impl;

import com.moas.crawler.model.TopCoin;
import com.moas.crawler.model.TopNews;
import com.moas.crawler.parser.TopNewsParser;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.service.TopCoinService;
import com.moas.crawler.service.TopNewsService;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TopNewsParserImpl implements TopNewsParser {

    @Autowired
    private TopNewsService topNewsService;

    @Autowired
    private TopCoinService topCoinService;

    @Autowired
    private WeiboRealtimeHopParser weiboRealtimeHopParser;

    @Autowired
    private BaiduHopParser baiduHopParser;

    @Autowired
    private Qihu360Parser qihu360Parser;

    @Autowired
    private Kr36Parser kr36Parser;

    @Autowired
    private WxbParser wxbParser;

    @Autowired
    private TechWebParser techWebParser;

    @Autowired
    private IiMediaParser iiMediaParser;

    @Autowired
    private Cto51Parser cto51Parser;

    @Autowired
    private IyiouParser iyiouParser;

    @Autowired
    private CsdnParser csdnParser;

    @Autowired
    private YqhParser yqhParser;

    @Autowired
    private SegmentParser segmentParser;

    @Autowired
    private JianshuParser jianshuParser;

    @Autowired
    private BitcoinParser bitcoinParser;

    @Autowired
    private BishijieParser bishijieParser;

    @Autowired
    private AexParser aexParser;

    @Autowired
    private CbstParser cbstParser;

    @Autowired
    private AminerParser aminerParser;

    List<TopNews> list = null;

    List<TopCoin> coinList = null;

    @Override
    public List<TopNews> parser(TopNewsUrl topNewsUrl, Element element) {
        if("微博热搜榜".equals(topNewsUrl.getNewsname())){
            list = weiboRealtimeHopParser.parser(topNewsUrl, element);
        }else if("百度实时热点".equals(topNewsUrl.getNewsname())){
            list = baiduHopParser.parser(topNewsUrl, element);
        }else if("36氪快讯".equals(topNewsUrl.getNewsname())){
            list = kr36Parser.parser(topNewsUrl, element);
        }else if("TechWeb资讯".equals(topNewsUrl.getNewsname())){
            list = techWebParser.parser(topNewsUrl, element);
        }else if("艾媒行业观察".equals(topNewsUrl.getNewsname())){
            list = iiMediaParser.parser(topNewsUrl, element);
        }else if("51CTO热点".equals(topNewsUrl.getNewsname())){
            list = cto51Parser.parser(topNewsUrl, element);
        }else if("亿欧快讯".equals(topNewsUrl.getNewsname())){
            list = iyiouParser.parser(topNewsUrl, element);
        }else if("思否热门".equals(topNewsUrl.getNewsname())){
            list = segmentParser.parser(topNewsUrl, element);
        }else if("简书程序员".equals(topNewsUrl.getNewsname())){
            list = jianshuParser.parser(topNewsUrl, element);
        }else if("虚拟币快讯".equals(topNewsUrl.getNewsname())){
            list = bitcoinParser.parser(topNewsUrl, element);
        }else if("币资讯".equals(topNewsUrl.getNewsname())){
            list = bishijieParser.parser(topNewsUrl, element);
        }else if("饮料工业".equals(topNewsUrl.getNewsname())){
            list = cbstParser.parser(topNewsUrl, element);
        }else if("AMiner资讯".equals(topNewsUrl.getNewsname())){
            list = aminerParser.parser(topNewsUrl, element);
        }
        if(list != null && !list.isEmpty()) {
            topNewsService.insert(list);
        }
        return list;
    }

    @Override
    public List<TopNews> parser(TopNewsUrl topNewsUrl, String pageSource) {
        if("360趋势".equals(topNewsUrl.getNewsname())){
            list = qihu360Parser.parser(topNewsUrl, pageSource);
        }else if("微信爆文".equals(topNewsUrl.getNewsname())){
            list = wxbParser.parser(topNewsUrl, pageSource);
        }else if("CSDN推荐".equals(topNewsUrl.getNewsname())){
            list = csdnParser.parser(topNewsUrl, pageSource);
        }else if("云栖资讯".equals(topNewsUrl.getNewsname())){
            list = yqhParser.parser(topNewsUrl, pageSource);
        }else if("安银交易".equals(topNewsUrl.getNewsname())){
            coinList = aexParser.parser(topNewsUrl, pageSource);
            if(coinList != null && !coinList.isEmpty()) {
                topCoinService.insert(coinList);
            }
            return new ArrayList<>();
        }
        if(list != null && !list.isEmpty()) {
            topNewsService.insert(list);
        }
        return list;
    }
}

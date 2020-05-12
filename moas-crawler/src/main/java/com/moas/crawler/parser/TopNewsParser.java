package com.moas.crawler.parser;

import com.moas.crawler.model.TopNews;
import com.moas.crawler.model.TopNewsUrl;
import org.jsoup.nodes.Element;

import java.util.List;

public interface TopNewsParser {

    List<TopNews> parser(TopNewsUrl topNewsUrl, Element element);

    List<TopNews> parser(TopNewsUrl topNewsUrl, String pageSource);
}

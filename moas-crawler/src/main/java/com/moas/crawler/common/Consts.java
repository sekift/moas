package com.moas.crawler.common;

/**
 * 常量
 */
public class Consts {

    //  是否有效 0 无效 1 有效，默认有效
    public static final Short STATUS_ENABLE = 1;
    public static final Short STATUS_DISABLE = 0;

    /**简体中文*/
    public static final Integer LANG_ID_ZH_CN = 0;
    /**繁体中文*/
    public static final Integer LANG_ID_ZH_HK = 1;
    /**英文*/
    public static final Integer LANG_ID_EN_US = 2;


    // 微博热点常量
    public static final String S_WEIBO_DOMAIN = "https://s.weibo.com";

    public static final String TOPRANK_DEFAULT = "5000000";

    public static final String QIHU_TOPRANK_DEFAULT = "100000";
    public static final String QIHU_DOMAIN = "http://www.so.com/s?ie=utf-8&src=zhishu&q=";

    public static final int KR36_TOPRANK_DEFAULT = 100000;
    public static final int KR36_RANGE = 2000;
    public static final int CTO15_RANGE = 800;
    public static final String KR36_DOMAIN = "https://36kr.com";

    public static final String SEGMENT_DOMAIN = "https://segmentfault.com";
    public static final String JIANSHU_DOMAIN = "https://www.jianshu.com";

    public static final String BITCOIN_DOMAIN = "https://www.bitcoin86.com";
    public static final String BISHIJIE_DOMAIN = "https://www.bishijie.com";

}
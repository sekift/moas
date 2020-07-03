# moas-back
moas，恐鸟，于1850年灭绝。在这里是一个集成SpringBoot等工具爬取新闻热点的爬虫。<br/>
体验网址：http://news.bubbt.com/h5 <br/>

## 项目介绍
moas-crawler爬虫+moas-back web+moas-front前端<br/>
#### 1、moas-crawler+moas-back配置
JDK：1.8.0_121<br/>
集成环境：IntelliJ IDEA 2019.1<br/>
项目管理：Maven 2.5.2<br/>
集成框架：SpringBoot 2.1.8+Spring 5.1.9<br/>
持久层框架：MyBatis 3.4.6+MyBatis-Generator 1.3.2<br/>
数据库：MySql 5.5.25<br/>
数据库连接池：Druid 1.1.10<br/>
日志框架：Logback 1.2.3<br/>
测试框架：Junit 4.12<br/>

#### 2、moas-front配置
使用HBuiderX制作的vue项目，具体可看官方文档（https://www.dcloud.net.cn/）。<br/>

## 项目配置
项目配置请看/doc/moas-crawler配置文档.doc，sql数据表信息请看back.sql。

## 功能更新
2020/07/03 更新<br />
1、增加moas-crawler分词功能，热点跟踪。<br />

2020/05/19 更新<br />
1、完善moas-crawler、moas-back项目。<br />
2、完善moas-front项目，打包并运行h5。<br />

2020/04/24 更新 <br />
1、第一个版本，整合爬虫moas-crawler。<br />
2、增加爬取微信、百度等11个网站热点。<br />
3、创建moas-back web项目。<br />
4、创建moas-front前端项目。<br />

## 开发moas-crawer
1、先在数据库top_news_url中增加爬取网站的信息；<br />
2、然后在parser/impl下增加对新加网站的解析，信息爬取；<br />
3、再修改parser/impl下的TopNewsParserImpl；<br />
4、调整入库即可。<br />

## 问题
1、moas-front打包后有一js文件300k+，加载启动缓慢，至少5秒左右。
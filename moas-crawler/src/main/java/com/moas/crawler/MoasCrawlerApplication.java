package com.moas.crawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.moas.crawler.dao")
@EnableTransactionManagement
public class MoasCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoasCrawlerApplication.class, args);
    }

}

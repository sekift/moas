package com.moas.crawler.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.moas.crawler.model.TopNewsUrl;
import com.moas.crawler.crawler.DynamicScheduleCrawler;
import com.moas.crawler.service.TopNewsUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 基于接口SchedulingConfigurer的动态定时任务
 *
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {

    private static Logger logger = LoggerFactory.getLogger(DynamicScheduleTask.class);
    /**
     * @brief 定时任务周期表达式
     */
    private String cron;

    @Autowired
    TopNewsUrlService topNewsUrlService;

    @Autowired
    DynamicScheduleCrawler dynamicScheduleCrawler;

    /**
     * 设置Scheduler用于注册计划任务
     * @return
     */
    @Bean(destroyMethod="shutdown")
    public Executor setExecutor(){
        //设置线程名称
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("dynamic-pool-%d").build();
        //创建线程池,x个线程
        return Executors.newScheduledThreadPool(2, namedThreadFactory);
    }
    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(setExecutor());

        List<TopNewsUrl> list = topNewsUrlService.selectAll();
        if (list == null || list.isEmpty()) {
            logger.info("数据库的任务list为空,list=" + list);
            return;
        }
        for (TopNewsUrl topNewsUrl : list) {
            taskRegistrar.addTriggerTask(
                    //1.添加任务内容(Runnable)
                    () -> {
                        if(topNewsUrl.getNewstype() == 0) {
                            dynamicScheduleCrawler.run(topNewsUrl);
                        }else if(topNewsUrl.getNewstype() == 1){
                            dynamicScheduleCrawler.runJson(topNewsUrl);
                        }
                        //System.out.println("topNewsUrl="+topNewsUrl.getNewsname()+":"+topNewsUrl.getCron());
                    },
                    //2.设置执行周期(Trigger)
                    triggerContext -> {
                        //2.2 合法性校验，错误会直接抛出错误
                        cron = topNewsUrl.getCron();
                        if (StringUtils.isEmpty(cron)) {
                            try {
                                throw new Exception("cron为空！");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        //2.3 返回执行周期(Date)
                        //System.out.println("cron="+cron);
                        return new CronTrigger(cron).nextExecutionTime(triggerContext);
                    }
            );
        }
    }
}
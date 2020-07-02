package com.moas.crawler.syn;

import com.moas.crawler.model.TopNews;
import com.moas.crawler.nlp.NlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class NlpSyn {

    private static final int corePoolSize = 4;
    private static final int maximumPoolSize = 10;
    private static final int keepAliveTime = 5 * 60;
    private static final String poolName = "nlp_syn";

    @Autowired
    private NlpService nlpService;

    private static ExecutorService threadpool = ThreadPoolsService.newExecutorService(
            corePoolSize, maximumPoolSize, keepAliveTime, poolName);

    public void setSynQueue(final TopNews topNews) {
        threadpool.execute(new Runnable() {
            public void run() {
                nlpService.nlpParser(topNews);
            }
        });
    }
}

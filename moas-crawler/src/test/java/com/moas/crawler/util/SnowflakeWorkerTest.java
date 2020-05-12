package com.moas.crawler.util;

import com.moas.crawler.util.SnowflakeIdWorker;
import org.junit.Test;

public class SnowflakeWorkerTest {

    @Test
    public void workerTest(){
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker();
        for (int i = 0; i < 1000; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }

}

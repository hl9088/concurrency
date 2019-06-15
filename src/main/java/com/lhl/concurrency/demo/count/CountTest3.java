package com.lhl.concurrency.demo.count;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by lihongli on 2019/5/22
 */
public class CountTest3 {

    private static Logger logger = LoggerFactory.getLogger(CountTest3.class);

    /**
     * 客户端请求线程数量
     */
    private static int clientThread = 1000;

    /**
     * 同时请求的并发线程数量
     */
    private static int totalThread = 200;

    private static LongAdder count = new LongAdder();

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        // 信号量
        Semaphore semaphore = new Semaphore(totalThread);
        // 控制所有任务都执行完
        CountDownLatch countDownLatch = new CountDownLatch(clientThread);
        for (int i = 0; i < clientThread; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    add3();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        logger.info("count = {}", count);
    }

    private static void add3() {
        count.increment();
    }
}

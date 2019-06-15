package com.lhl.concurrency.demo.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock的用法
 * Created by lihongli on 2019/6/15
 */
public class ReenLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(new Task(lock));
            System.out.println(i);
        }
        service.shutdown();
    }


    static class Task implements Runnable {

        private ReentrantLock lock;

        public Task(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread() + "正在执行");
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

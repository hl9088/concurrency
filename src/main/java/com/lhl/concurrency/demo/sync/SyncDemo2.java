package com.lhl.concurrency.demo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 不可中断锁 适合竞争不激烈 可读性好
 * Created by lihongli on 2019/5/22
 */
public class SyncDemo2 {

    // 修饰一个类 锁了所有对象
    public void test1() {
        synchronized (SyncDemo2.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1 - " + i);
            }
        }
    }

    // 修饰一个静态方法 锁了所有对象
    public static synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(" test2 - " + i);
        }
    }

    public static void main(String[] args){
        SyncDemo2 demo = new SyncDemo2();
        SyncDemo2 demo2 = new SyncDemo2();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            demo.test2();
        });
        service.execute(()->{
            demo2.test2();
        });
    }
}

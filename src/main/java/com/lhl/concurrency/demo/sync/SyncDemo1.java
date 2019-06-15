package com.lhl.concurrency.demo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihongli on 2019/5/22
 */
public class SyncDemo1 {

    // 修饰一个代码块 锁了调用的对象 不同的对象调用不影响
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1 - " + i);
            }
        }
    }

    // 修饰一个方法 锁了调用的对象 不同的对象调用不影响
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(" test2 - " + i);
        }
    }

    public static void main(String[] args){
        SyncDemo1 demo = new SyncDemo1();
        SyncDemo1 demo2 = new SyncDemo1();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            demo.test2();
        });
        service.execute(()->{
            demo2.test2();
        });
    }
}

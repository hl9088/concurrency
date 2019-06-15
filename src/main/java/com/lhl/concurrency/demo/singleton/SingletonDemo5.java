package com.lhl.concurrency.demo.singleton;

import com.lhl.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 * Created by lihongli on 2019/5/22
 */
@ThreadSafe
public class SingletonDemo5 {

    private SingletonDemo5() {
    }

    private volatile static SingletonDemo5 instance = null;

    public SingletonDemo5 getInstance() {
        if (instance == null) {
            // 双重检查机制
            synchronized (SingletonDemo5.class) {
                if (instance == null) {
                    instance = new SingletonDemo5();
                }
            }
        }
        return instance;
    }
}

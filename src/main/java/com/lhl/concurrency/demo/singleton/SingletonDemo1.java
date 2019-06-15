package com.lhl.concurrency.demo.singleton;

import com.lhl.concurrency.annotation.ThreadNotSafe;

/**
 * 懒汉模式
 * Created by lihongli on 2019/5/22
 */
@ThreadNotSafe
public class SingletonDemo1 {

    private SingletonDemo1() {
    }

    private static SingletonDemo1 instance = null;

    // 单线程下安全 多线程不安全
    public SingletonDemo1 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo1();
        }
        return instance;
    }
}

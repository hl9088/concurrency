package com.lhl.concurrency.demo.singleton;

import com.lhl.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * Created by lihongli on 2019/5/22
 */
@ThreadSafe
public class SingletonDemo2 {

    private SingletonDemo2() {
    }

    private static SingletonDemo2 instance = new SingletonDemo2();

    public SingletonDemo2 getInstance() {
        return instance;
    }

    /*
    // 使用静态代码块也可以实现
    private static SingletonDemo2 instance = null;

    static {
        instance = new SingletonDemo2();
    }
    */
}

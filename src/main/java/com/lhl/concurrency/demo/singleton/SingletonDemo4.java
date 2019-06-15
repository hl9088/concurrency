package com.lhl.concurrency.demo.singleton;

import com.lhl.concurrency.annotation.NotRecommend;
import com.lhl.concurrency.annotation.ThreadNotSafe;

/**
 * 懒汉模式 不推荐使用
 * Created by lihongli on 2019/5/22
 */
@ThreadNotSafe
@NotRecommend
public class SingletonDemo4 {

    private SingletonDemo4() {
    }

    private static SingletonDemo4 instance = null;

    public SingletonDemo4 getInstance() {
        if (instance == null) {
            // 双重检查机制 不安全 因为cpu指令重排
            synchronized (SingletonDemo4.class) {
                if (instance == null) {
                    // 1 分配内存地址
                    // 2 实例化对象
                    // 3 将对象指向分配的地址
                    instance = new SingletonDemo4();
                }
            }
        }
        return instance;
    }
}

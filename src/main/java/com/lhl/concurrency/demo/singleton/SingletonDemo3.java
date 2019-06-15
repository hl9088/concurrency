package com.lhl.concurrency.demo.singleton;

import com.lhl.concurrency.annotation.NotRecommend;
import com.lhl.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式 不推荐使用 方法锁 资源开销比较大
 * Created by lihongli on 2019/5/22
 */
@ThreadSafe
@NotRecommend
public class SingletonDemo3 {

    private SingletonDemo3() {
    }

    private static SingletonDemo3 instance = null;

    public synchronized SingletonDemo3 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo3();
        }
        return instance;
    }
}

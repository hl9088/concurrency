package com.lhl.concurrency.demo.singleton;

import com.lhl.concurrency.annotation.Recommend;
import com.lhl.concurrency.annotation.ThreadSafe;

/**
 * 使用enum枚举模式
 * Created by lihongli on 2019/5/22
 */
@ThreadSafe
@Recommend
public class SingletonDemo6 {

    private SingletonDemo6() {
    }

    public static SingletonDemo6 getInstance() {
        return Inner.INSTANCE.getSingleton();
    }

    private enum Inner {
        INSTANCE;

        private SingletonDemo6 singleton;

        // JVM保证只执行一次
        Inner() {
            singleton = new SingletonDemo6();
        }

        public SingletonDemo6 getSingleton() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println(SingletonDemo6.getInstance());
        System.out.println(SingletonDemo6.getInstance());
    }
}

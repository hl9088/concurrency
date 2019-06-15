package com.lhl.concurrency.demo.threadlocal.simple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lihongli on 2019/5/23
 */
public class Son implements Cloneable {

    ThreadLocal<Integer> t = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public int get() {
        return t.get();
    }

    public void set() {
        t.set(t.get() + 10);


    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int increment = atomicInteger.getAndIncrement();
        int i = atomicInteger.get();
        int increment2 = atomicInteger.getAndIncrement();
        int i2 = atomicInteger.get();
        int increment3 = atomicInteger.getAndIncrement();
        int i3 = atomicInteger.get();
        System.out.println(increment);
        System.out.println(i);
        System.out.println(increment2);
        System.out.println(i2);
        System.out.println(increment3);
        System.out.println(i3);
    }
}


class Transfer implements Runnable {
    Son son;

    public Transfer(Son son) {
        this.son = son;
    }

    @Override
    public void run() {
        System.out.println(son);
        System.out.println(son.t);
        for (int i = 0; i < 10; i++) {
            son.set();
            System.out.println(Thread.currentThread() + "-" + son.get());
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        Transfer t = new Transfer(son);

        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(son.get());
    }
}
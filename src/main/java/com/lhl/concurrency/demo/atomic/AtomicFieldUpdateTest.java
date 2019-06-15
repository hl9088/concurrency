package com.lhl.concurrency.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by lihongli on 2019/5/22
 */
public class AtomicFieldUpdateTest {

    private static AtomicIntegerFieldUpdater<AtomicFieldUpdateTest> atomicIntegerFieldUpdater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicFieldUpdateTest.class, "count");

    // 必须 volatile 修饰 不可用static修饰
    private volatile int count = 100;

    public static void main(String[] args) {
        AtomicFieldUpdateTest atomicFieldUpdateTest = new AtomicFieldUpdateTest();
        if (atomicIntegerFieldUpdater.compareAndSet(atomicFieldUpdateTest, 100, 120)) {
            System.out.println("update success 1 " + atomicFieldUpdateTest.count);
        }
        if (atomicIntegerFieldUpdater.compareAndSet(atomicFieldUpdateTest, 100, 120)) {
            System.out.println("update success 2 " + atomicFieldUpdateTest.count);
        } else {
            System.err.println("update error " + atomicFieldUpdateTest.count);
        }
    }
}
package com.lhl.concurrency.demo.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by lihongli on 2019/5/22
 */
public class AtomicReferenceTest {

    private static AtomicReference<Integer> reference = new AtomicReference<>(0);

    public static void main(String[] args){
        reference.compareAndSet(0, 1);
        reference.compareAndSet(0, 3);
        reference.compareAndSet(1, 2);
        reference.compareAndSet(3, 4);
        System.out.println(reference.get());
    }
}

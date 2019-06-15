package com.lhl.concurrency.demo.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题
 * Created by lihongli on 2019/5/22
 */
public class AtomicStampedReferenceTest {

    private static Integer count = 100;

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(count, 2);

    public static void main(String[] args) {
        if (atomicStampedReference.compareAndSet(100, 101, 2, 3)) {
            System.out.println(atomicStampedReference.getReference());
            System.out.println(atomicStampedReference.getStamp());
        }
        if (atomicStampedReference.compareAndSet(101, 100, 3, 4)) {
            System.out.println(atomicStampedReference.getReference());
            System.out.println(atomicStampedReference.getStamp());
        }
        if (atomicStampedReference.compareAndSet(100, 101, 2, 3)) {
            System.out.println(atomicStampedReference.getReference());
            System.out.println(atomicStampedReference.getStamp());
        } else {
            System.err.println(atomicStampedReference.getReference());
            System.err.println(atomicStampedReference.getStamp());
        }
    }
}

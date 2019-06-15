package com.lhl.concurrency.demo.threadlocal;

/**
 * Created by lihongli on 2019/5/22
 */
public class RequestHolder {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal();

    public static void add(Long id){
        threadLocal.set(id);
    }

    public static Long getId(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }
}

package com.lhl.concurrency.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 不可变对象
 * Created by lihongli on 2019/5/22
 */
public class ImmutableDemo {

    private static final Integer a = 1;

    private static final String b = "11";

    private static Map<Integer, String> map = new HashMap<>();

    static {
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args){
//        a = 2;
//        b = "xx";
        map.put(1,"xxx");
    }
}

package com.branodn.mmall.example.immutable;

import com.branodn.mmall.annotation.NotThreadSafe;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brandoncui on 2019/1/29.
 */
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;
        map.put(1, 123);
        System.out.println(map.get(1));
    }

    private void test(final int a){
        // 不允许修改
//        a = 1;
    }
}

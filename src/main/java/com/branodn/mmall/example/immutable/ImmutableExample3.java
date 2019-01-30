package com.branodn.mmall.example.immutable;

import com.branodn.mmall.annotation.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Brandoncui on 2019/1/29.
 */

public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1, 2, 3);
    private final static ImmutableList set = ImmutableList.copyOf(list);
    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1,2, 3, 4);
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
//        list.add(4);
//        set.add(5);
        System.out.println(map2.get(3));
    }

}

package com.branodn.mmall.example.atomic;


import lombok.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * Created by Brandoncui on 2019/1/9.
 */
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
       if(updater.compareAndSet(example5, 100, 120)){
//           System.out.println("update success " + example5.getCount());
       }
    }
}

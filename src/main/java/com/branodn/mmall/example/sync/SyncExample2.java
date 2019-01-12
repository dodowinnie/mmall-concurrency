package com.branodn.mmall.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Brandoncui on 2019/1/9.
 */
public class SyncExample2 {

    public static void test1(int j){
        synchronized (SyncExample2.class){
            for(int i = 0; i < 10; i++){
                System.out.println(j + " test1 i= " + i);
            }
        }
    }

    public synchronized static void test2(int j){
        for(int i = 0; i < 10; i++){
            System.out.println(j + " test2 i= " + i);
        }
    }

    public static void main(String[] args) {
        SyncExample2 example1 = new SyncExample2();
        SyncExample2 example2 = new SyncExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}

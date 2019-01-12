package com.branodn.mmall.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Brandoncui on 2019/1/9.
 */
public class SyncExample1 {

    // 同步代码块
    public void test1(int j){
        synchronized (this){
            for(int i = 0; i < 10; i++){
                System.out.println(j + " test1 i= " + i);
            }
        }
    }

    public synchronized void test2(int j){
        for(int i = 0; i < 10; i++){
            System.out.println(j + " test2 i= " + i);
        }
    }


    public static void main(String[] args) {
        SyncExample1 example1 = new SyncExample1();
        SyncExample1 example2 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }

}

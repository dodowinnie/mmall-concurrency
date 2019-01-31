package com.branodn.mmall.example.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample3 {

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
       final Semaphore semaphore = new Semaphore(3);
        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            exec.execute(() -> {
                try {
                   if(semaphore.tryAcquire()){ // 尝试获取一个许可
                       test(threadNum);
                       semaphore.release(); // 释放一个许可
                   }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        System.out.println("finish......");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {

        System.out.println(threadNum);
        Thread.sleep(1000);
    }

}

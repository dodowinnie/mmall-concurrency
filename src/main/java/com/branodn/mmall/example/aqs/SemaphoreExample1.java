package com.branodn.mmall.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
       final Semaphore semaphore = new Semaphore(5);
        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(2);
                    test(threadNum);
                    semaphore.release(2);
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

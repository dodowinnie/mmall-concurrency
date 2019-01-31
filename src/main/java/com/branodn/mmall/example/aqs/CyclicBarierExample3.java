package com.branodn.mmall.example.aqs;

import java.util.concurrent.*;

public class CyclicBarierExample3 {

    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        System.out.println("优先执行。。。");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(threadNum + " is ready");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(threadNum + " is continue");
    }
}

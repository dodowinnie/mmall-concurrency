package com.branodn.mmall.example.concurrent;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteArrayListExample {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static List<Integer> li = new CopyOnWriteArrayList<Integer>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0; i < clientTotal; i++){
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // 判断当前进程是否允许被执行
                    update(count);
                    semaphore.release(); // 释放当前进程
                } catch (InterruptedException e) {
//                    log.error("exception", e);
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
//        log.info("count {}", count);
        System.out.println("size = " + li.size());

    }

    private static void update(int i){
        li.add(i);
    }
}

package com.branodn.mmall.example.syncContainer;


import com.branodn.mmall.annotation.ThreadSafe;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class CollectionsExample1 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

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
        System.out.println("size = " + list.size());

    }

    private static void update(int i){
        list.add(i);
    }
}

package com.branodn.mmall.example.count;

import com.branodn.mmall.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Brandoncui on 2019/1/7.
 */
@Slf4j
@ThreadSafe
public class CountExample3 {


    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
//        CountExample3 example = new CountExample3();
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0; i < clientTotal; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // 判断当前进程是否允许被执行
                    add();
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
        System.out.println("count=" + count);
    }

    private synchronized static void add(){
        synchronized (CountExample3.class){
            count++;
        }

    }
}

package com.branodn.mmall.example.atomic;

import com.branodn.mmall.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Brandoncui on 2019/1/7.
 */
@Slf4j
@NotThreadSafe
public class AtomicExample1 {


    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
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

    private static void add(){
        count++;
    }
}

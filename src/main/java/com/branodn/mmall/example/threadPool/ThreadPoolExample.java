package com.branodn.mmall.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            final int index = i;
            executorService.execute(() -> {
                System.out.println("task:" + index);
            });
        }
        executorService.shutdown();
    }
}

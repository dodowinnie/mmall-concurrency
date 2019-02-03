package com.branodn.mmall.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        System.out.println(System.currentTimeMillis());
//       scheduledExecutorService.schedule(() -> {
//           System.out.println("schedule run" + System.currentTimeMillis());
//       }, 3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule run" + System.currentTimeMillis());
            }
        },1, 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
    }
}

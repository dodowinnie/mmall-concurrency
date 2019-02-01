package com.branodn.mmall.example.aqs;

import java.util.concurrent.*;

public class FutureExample {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("do something in callable .....");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        System.out.println("do something in main .....");
        Thread.sleep(1000);
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}

package com.branodn.mmall.example.aqs;

import java.util.concurrent.*;

public class FutureTaskExample {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("do something in callable .....");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
       FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
           @Override
           public String call() throws Exception {
               System.out.println("do something in callable .....");
               Thread.sleep(5000);
               return "Done";
           }
       });

       new Thread(futureTask).start();
        System.out.println("do something in main....");
        Thread.sleep(1000);
        String result = futureTask.get();
        System.out.println("get result....");
        System.out.println(result);
    }
}

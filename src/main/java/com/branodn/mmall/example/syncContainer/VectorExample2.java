package com.branodn.mmall.example.syncContainer;


import com.branodn.mmall.annotation.NotThreadSafe;
import com.branodn.mmall.annotation.ThreadSafe;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@NotThreadSafe
public class VectorExample2 {

  private static Vector<Integer> vector = new Vector<>();


    public static void main(String[] args) {
        while(true){
            for(int i = 0; i < 10; i++){
                vector.add(i);
            }

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10; i++){
                        vector.remove(i);
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10; i++){
                        vector.remove(i);
                    }
                }
            });

            t1.start();
            t2.start();
        }


    }
}

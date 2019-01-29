package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 * 懒汉式，线程安全
 */
public class SingletonExa5 {

    private static volatile SingletonExa5 instance = null;

    private SingletonExa5(){

    }

    public static SingletonExa5 getInstance(){
        if (instance == null){
            synchronized (SingletonExa5.class){
                if(instance == null){
                    instance = new SingletonExa5();
                }
            }
        }
        return instance;
    }
}

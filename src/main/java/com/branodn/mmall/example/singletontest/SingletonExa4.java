package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 * 懒汉式，线程不安全
 */
public class SingletonExa4 {

    private static SingletonExa4 instance = null;

    private SingletonExa4(){

    }

    public static SingletonExa4 getInstance(){
        if (instance == null){
            synchronized (SingletonExa4.class){
                if(instance == null){
                    instance = new SingletonExa4();
                }
            }
        }
        return instance;
    }
}

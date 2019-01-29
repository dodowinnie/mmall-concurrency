package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 * 饿汉式
 */
public class SingletonExa2 {

    private static SingletonExa2 instance = new SingletonExa2();

    private SingletonExa2(){

    }

    public static SingletonExa2 getInstance(){
        return instance;
    }
}

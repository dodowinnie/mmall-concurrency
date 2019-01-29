package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 * 懒汉式
 */
public class SingletonExa1 {

    private static SingletonExa1 instance = null;

    private SingletonExa1(){

    }

    private static SingletonExa1 getInstance(){
        if(instance == null){
            instance = new SingletonExa1();
        }
        return instance;
    }
}

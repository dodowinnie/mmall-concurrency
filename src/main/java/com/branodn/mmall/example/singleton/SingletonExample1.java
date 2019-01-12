package com.branodn.mmall.example.singleton;

import com.branodn.mmall.annotation.NotThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 懒汉式
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有化构造函数
    private SingletonExample1(){

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }



}

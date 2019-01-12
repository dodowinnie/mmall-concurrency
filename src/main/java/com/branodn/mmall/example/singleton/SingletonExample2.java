package com.branodn.mmall.example.singleton;

import com.branodn.mmall.annotation.NotThreadSafe;
import com.branodn.mmall.annotation.ThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 饿汉式，如果实例化时需要做很多操作，那么实例化时间会很长，而且如果不用的话会造成资源的浪费
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有化构造函数
    private SingletonExample2(){

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance(){

        return instance;
    }



}

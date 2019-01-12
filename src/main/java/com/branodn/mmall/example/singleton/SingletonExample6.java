package com.branodn.mmall.example.singleton;

import com.branodn.mmall.annotation.ThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 饿汉式，如果实例化时需要做很多操作，那么实例化时间会很长，而且如果不用的话会造成资源的浪费
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有化构造函数
    private SingletonExample6(){

    }

    // 单例对象
    private static SingletonExample6 instance = null;
    static {
        instance = new SingletonExample6();
    }



    // 静态的工厂方法
    public static SingletonExample6 getInstance(){

        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }



}

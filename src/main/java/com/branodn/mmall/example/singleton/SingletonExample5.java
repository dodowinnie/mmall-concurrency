package com.branodn.mmall.example.singleton;


import com.branodn.mmall.annotation.ThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 懒汉式-线程安全，
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有化构造函数
    private SingletonExample5(){

    }

    /**
     * 1、分配对象内存空间
     * 2、初始化对象
     * 3、设置instance指向刚分配的内存
     */


    // 单例对象 volatile + 双重检测机制 可以禁止指令重排
    private volatile static SingletonExample5 instance = null;

    // 静态的工厂方法
    public static SingletonExample5 getInstance(){

        if (instance == null){ // 双重检测机制
            synchronized (SingletonExample5.class){ // 同步锁
                if(instance == null) {
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }



}

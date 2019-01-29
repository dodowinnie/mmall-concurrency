package com.branodn.mmall.example.singleton;

import com.branodn.mmall.annotation.NotRecommend;
import com.branodn.mmall.annotation.NotThreadSafe;
import com.branodn.mmall.annotation.ThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 懒汉式-线程不安全，
 */
@NotThreadSafe
public class SingletonExample4 {

    // 私有化构造函数
    private SingletonExample4(){

    }

    /**
     * 1、分配对象内存空间
     * 2、初始化对象
     * 3、设置instance指向刚分配的内存
     *
     * 如果发生指令重排，容易发生问题
     * 发生指令重排，上述顺序变成 1-3-2
     * 一个线程先执行 3 但是还没有初始化对象，另一个线程在双重检测机制时发现instance不为null，获取到了未初始化得到实例，容易出现问题
     *
     *
     */


    // 单例对象
    private static SingletonExample4 instance = null;

    // 静态的工厂方法
    public static SingletonExample4 getInstance(){

        if (instance == null){ // 双重检测机制
            synchronized (SingletonExample4.class){ // 同步锁
                if(instance == null) {
                    instance = new SingletonExample4();
                }
            }

        }
        return instance;
    }



}

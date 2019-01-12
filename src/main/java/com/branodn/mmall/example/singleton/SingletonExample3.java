package com.branodn.mmall.example.singleton;

import com.branodn.mmall.annotation.NotRecommend;
import com.branodn.mmall.annotation.ThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 懒汉式-线程安全，不推荐，因为synchronized会造成性能下降
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有化构造函数
    private SingletonExample3(){

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();

        }
        return instance;
    }



}

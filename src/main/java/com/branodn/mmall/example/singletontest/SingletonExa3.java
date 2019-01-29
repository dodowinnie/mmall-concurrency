package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 * 懒汉式，线程安全，不推荐，synchronized会造成性能下降
 */
public class SingletonExa3 {

    private static SingletonExa3 instance = null;

    private SingletonExa3(){

    }

    public static synchronized SingletonExa3 getInstance(){
        if(instance == null){
            instance = new SingletonExa3();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonExa3 s1 = SingletonExa3.getInstance();
        SingletonExa3 s2 = SingletonExa3.getInstance();
        System.out.println(s1 == s2);
    }
}

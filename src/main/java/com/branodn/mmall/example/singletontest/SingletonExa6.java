package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 */
public class SingletonExa6 {

    private static SingletonExa6 instance = null;

    static {
        instance = new SingletonExa6();
    }

    private SingletonExa6(){

    }

    public static SingletonExa6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        SingletonExa6 s1 = SingletonExa6.getInstance();
        SingletonExa6 s2 = SingletonExa6.getInstance();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

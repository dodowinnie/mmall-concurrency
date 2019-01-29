package com.branodn.mmall.example.singletontest;

/**
 * Created by Brandoncui on 2019/1/13.
 * 饿汉式推荐写法
 */
public class SingletonExa7 {



    private SingletonExa7(){

    }

    public static SingletonExa7 getInstance(){
        return Single.INSTANCE.getInstance();
    }

    private enum Single{
        INSTANCE;

        private SingletonExa7 instance;

        Single(){
            instance = new SingletonExa7();
        }

        public SingletonExa7 getInstance(){
            return  instance;
        }
    }
}

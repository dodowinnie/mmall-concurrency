package com.branodn.mmall.example.threadLocal;

public class Bank {

    int i = 100;
    ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return i;
        }
    };

    public int get(){
        return t.get();
    }

    public void set(int num){
        t.set(t.get() + num);
    }
}

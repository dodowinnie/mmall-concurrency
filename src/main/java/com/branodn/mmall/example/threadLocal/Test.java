package com.branodn.mmall.example.threadLocal;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Transfer tf1 = new Transfer(bank,10);
        Transfer tf2 = new Transfer(bank,20);
        Thread t1 = new Thread(tf1);
        Thread t2 = new Thread(tf2);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(bank.get());
    }

}

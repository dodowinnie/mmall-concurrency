package com.branodn.mmall.example.threadLocal;

public class Transfer implements Runnable {
    Bank bank;

    int num;

    public Transfer(Bank bank, int num) {
        this.bank = bank;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            bank.set(num);
            System.out.println(Thread.currentThread().getName() + "====" + bank.get());
        }
    }
}

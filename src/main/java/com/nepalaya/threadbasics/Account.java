package com.nepalaya.threadbasics;

import java.util.concurrent.atomic.AtomicInteger;


public class Account {

    public final Object object = new Object();

    public AtomicInteger balance = new AtomicInteger();

    public int getBalance() {
        return balance.get();
    }

    public synchronized void withDraw(int amount) {
            System.out.println("Performing withdraw by: " + Thread.currentThread().getName());
          balance.set(balance.get()-amount);
    }

    public synchronized  void deposit(int amount) {
//        synchronized (object) {
            System.out.println("Performing deposit by: " + Thread.currentThread().getName());
            //write   //read
            balance.set(balance.get()+amount);
//        }
    }
}

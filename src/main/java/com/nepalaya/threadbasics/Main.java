package com.nepalaya.threadbasics;

public class Main {
    public static void main(String[] args) {
        System.out.println("Thread Day");
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t1.start();
        t1.start();
        t2.start();
        t3.start();

        // how many thread has been created -> 4




    }
}

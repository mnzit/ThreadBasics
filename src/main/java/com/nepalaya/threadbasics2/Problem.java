package com.nepalaya.threadbasics2;

public class Problem {

    public static final String resource1 = "Resource-1";
    public static final String resource2 = "Resource-2";


    public static void main(String args[]){

        Thread thread1 = new Thread(() -> {
            synchronized (resource1){
                System.out.println(resource1+" is accessed by "+Thread.currentThread().getName());
                synchronized (resource2){
                    System.out.println(resource2+ "is accessed by "+Thread.currentThread().getName());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2){
                System.out.println(resource2+" is accessed by "+Thread.currentThread().getName());
                synchronized (resource1){
                    System.out.println(resource1+ "is accessed by "+Thread.currentThread().getName());
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

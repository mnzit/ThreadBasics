package com.nepalaya.threadbasics2;

public class Problem {

    public static final String resource1 = "resource1";
    public static final String resource2 = "resource2";


    public static void main(String args[]){

        Thread thread1 = new Thread(() -> {
            synchronized (resource1){
                System.out.println(resource1+" is accessed !");
                synchronized (resource2){
                    System.out.println(resource2+ "is accessed !");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2){
                System.out.println(resource2+" is accessed !");
                synchronized (resource1){
                    System.out.println(resource1+ "is accessed !");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

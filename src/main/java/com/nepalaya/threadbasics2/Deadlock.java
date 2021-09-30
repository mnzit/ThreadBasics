package com.nepalaya.threadbasics2;

public class Deadlock {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("[Start] - Printed by: "+ Thread.currentThread().getName());
        Thread thread1 = new Thread(new RunnableDemo(mainThread));

        thread1.start();

        try {
            thread1.join();
        }catch(Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        int i = 0;

        while (i <=10000){
            System.out.println("This is printed by: " + Thread.currentThread().getName() + ", i: " + i++);
        }

        System.out.println("[End] - Printed by: "+ Thread.currentThread().getName());
    }
}

class RunnableDemo implements Runnable{

    private Thread thread;

    public RunnableDemo(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try{
            System.out.println("[Start] - Printed by: "+ Thread.currentThread().getName());
            thread.join();
            System.out.println("[Stop] - Printed by: "+ Thread.currentThread().getName());
        }catch(Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
    }
}

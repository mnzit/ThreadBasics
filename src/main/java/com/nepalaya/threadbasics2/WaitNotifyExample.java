package com.nepalaya.threadbasics2;

public class WaitNotifyExample {

    public static void main(String[] args) {
        Integer lock = 0;
        Thread waiter = new Thread(new Waiter(lock));

        Thread notifier = new Thread(new Notifier(lock));
        waiter.start();
        notifier.start();
    }

}

class Waiter implements Runnable {

    public Integer lock;

    public Waiter(Integer lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Waiter is now waiting on the lock");
                lock.wait();
                System.out.println("Waiter just got notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Notifier implements Runnable {

    public Integer lock;

    public Notifier(Integer lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            try {
                // sleep!
                Thread.sleep(1000);
                System.out.println("About to notify the waiter..");
                lock.notify();
                System.out.println("Done notifying the waiter.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
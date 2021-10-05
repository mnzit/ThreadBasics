package com.nepalaya.threadbasics2;

public class NotifyTester {

    private static Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        int i = 1;
        while (true) {
            if (i == numbers.length) {
                i = 1;
            }
            Thread thread = new Thread(new Task(numbers[i]));
            thread.start();
            try{
            Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println("[Exception] - Exception: " + ex.getMessage());
            }
        }
    }
}

class Task implements Runnable {

    private Integer number;

    public Task(Integer number) {
        this.number = number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (number) {
            try {
                number.wait();
                System.out.println("[Start] - Printed by: " + Thread.currentThread().getName());
                System.out.println("[Process] - Processing: " + number);
                System.out.println("[Stop] - Printed by: " + Thread.currentThread().getName());
                number.notifyAll();
            } catch (Exception ex) {
                System.out.println("[Exception] - Exception: " + ex.getMessage());
            }
        }
    }
}

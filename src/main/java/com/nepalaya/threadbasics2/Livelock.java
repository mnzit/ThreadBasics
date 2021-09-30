package com.nepalaya.threadbasics2;

public class Livelock {

    public static void main(String[] args) {
        // Shared Resource
        Integer x =0;

        Thread incrementor = new Thread(() -> { new LiveLockIncr(x).increment();});
        Thread decrementor = new Thread(() -> { new LiveLockDecr(x).decrement();});

        incrementor.start();
        decrementor.start();

    }
}


class LiveLockIncr {
    Integer x;

    public LiveLockIncr(Integer x) {
        this.x = x;
    }

    public void increment(){
        do {
            synchronized (x){
                x++; // read+write operation
                System.out.println("A toss the ball: "+ x);
            }
        }while(x<10);
    }
}

class LiveLockDecr {
    Integer x;

    public LiveLockDecr(Integer x) {
        this.x = x;
    }

    public void decrement(){
        do {
            synchronized (x){
                x--; // read+write operation
                System.out.println("B toss the ball:"+ x);
            }
        }while(x> -10);
    }
}

package com.nepalaya.threadbasics;

public class Main {
    public static void main(String[] args) {

        String painting = "MonaLisa-";

        for (int i = 1; i <= 50; i++) {
            new Thread(new Painter(painting + i, 10)).start();
        }

    }
}

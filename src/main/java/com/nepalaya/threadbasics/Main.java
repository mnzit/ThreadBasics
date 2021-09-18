package com.nepalaya.threadbasics;

public class Main {
    public static void main(String[] args) {

        String painting = "Monalisa-";
        String painter = "Painter-";

        for (int i = 1; i <= 10; i++) {
            new Thread(new Painter(painter + i, painting + i, i)).start();
        }
    }
}

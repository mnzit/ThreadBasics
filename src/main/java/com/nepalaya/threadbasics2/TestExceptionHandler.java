package com.nepalaya.threadbasics2;

public class TestExceptionHandler {
    public static void main(String[] args) {
        System.out.println("Start");
        ExceptionHandler.handle(() -> System.out.println(1 / 0));
        System.out.println("End");
    }
}

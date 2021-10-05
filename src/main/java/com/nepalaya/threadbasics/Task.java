package com.nepalaya.threadbasics;

import com.nepalaya.threadbasics2.ExceptionHandler;
import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class Task implements Callable<Object> {

    private Integer taskId;

    @Override
    public Object call() {
        System.out.println("Task-" + taskId + " is started by: " + Thread.currentThread().getName());
        ExceptionHandler.handle(() -> Thread.sleep(1000));
        System.out.println("Task-" + taskId + " is ended by: " + Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }
}

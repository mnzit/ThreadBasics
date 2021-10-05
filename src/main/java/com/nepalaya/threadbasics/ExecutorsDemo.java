package com.nepalaya.threadbasics;

import com.nepalaya.threadbasics2.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Task> tasks = new ArrayList<>();
        IntStream.range(0, 20).forEach((i) -> tasks.add(new Task(i)));
        ExceptionHandler.handle(() -> executorService.invokeAll(tasks));
        executorService.shutdown();
    }
}

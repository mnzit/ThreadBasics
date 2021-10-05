package com.nepalaya.threadbasics2;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ThreadChain {
    public static void main(String[] args) {
        try {
            String currentThread = Thread.currentThread().getName();
            System.out.println("This is start printed by PUT: " + currentThread);
            List<Employee> employees = new ArrayList<>();
            Thread thread = new Thread(new ChainMaker(5L, employees));
            Thread.sleep(100);
            thread.start();
            thread.join();
            Thread.sleep(100);
            System.out.println("Total Employees: "+ employees);
            System.out.println("This is end printed by POP: " + currentThread);
        } catch (Exception ex) {
            LogHandler.exception(ex);
        }
    }
}

/**
 * Create a chain main thread waits for thread to complete, the thread also creates another thread and waits until another thread completes
 * Main -> Thread 0 -> Thread 1 -> Thread 2 -> Thread 3
 * LIFO
 */

@AllArgsConstructor
@NoArgsConstructor
class ChainMaker implements Runnable {

    private Long level;
    private List<Employee> employees;

    @Override
    public void run() {
        if (level >= 1) {
            level--;
            try {
                String currentThread = Thread.currentThread().getName();
                Thread.sleep(100);

                Thread thread = new Thread(new ChainMaker(level, employees));
                thread.start();
                System.out.println("This is start printed by PUT: " + currentThread);
                thread.join();

                employees.add(new Employee(level, currentThread));
                Thread.sleep(100);
                System.out.println("This is end printed by POP: " + currentThread);
            } catch (Exception ex) {
                LogHandler.exception(ex);
            }
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Employee {
    private Long id;
    private String name;
}

package com.nepalaya.threadbasics2.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void process() throws Exception;
}

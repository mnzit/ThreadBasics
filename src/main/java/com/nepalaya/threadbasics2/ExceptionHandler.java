package com.nepalaya.threadbasics2;

public class ExceptionHandler {

    public static void handle(ExceptionWrapper wrapper) {
        try {
            wrapper.process();
        } catch (Exception ex) {
            LogHandler.exception(ex);
        }
    }
}

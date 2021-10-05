package com.nepalaya.threadbasics2.exception;

import com.nepalaya.threadbasics2.util.LogHandler;

public class ExceptionHandler {

    public static void handle(ExceptionWrapper wrapper) {
        try {
            wrapper.process();
        } catch (Exception ex) {
            LogHandler.exception(ex);
        }
    }
}

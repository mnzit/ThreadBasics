package com.nepalaya.threadbasics;

public class Painting {

    public String name;
    public String painterName;

    public Painting(String name, String painterName) {
        this.name = name;
        this.painterName = painterName;
    }

    @Override
    public String toString() {
        return String.format("%s is painting %s", painterName, name);
    }
}

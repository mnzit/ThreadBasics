package com.nepalaya.threadbasics;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Painter implements Runnable {

    private String painting;
    private long timeTaken;

    public Painter(String painting, long timeTaken) {
        this.painting = painting;
        this.timeTaken = timeTaken;
    }

    public void paint() {
        Instant before = Instant.now();

        String name = Thread.currentThread().getName();
        System.out.println("Painter-" + name + " started painting at: " + new Date().getTime()+"will take time: "+timeTaken);
        System.out.println("Painter is currently painting: " + new Painting(painting, name));

        // stimulating/ faking painting
        try {
            Thread.sleep(1000*timeTaken);
        } catch (InterruptedException ex) {
            System.err.println("Exception :: " + ex.getMessage());
        }

        System.out.println(name+ " finished painting in "+timeTaken+ " seconds");

        Instant after = Instant.now();
        long delta = Duration.between(before, after).toMillis(); // .toWhatsoever()
        System.out.println("Actually finshed in: "+delta);
    }

    @Override
    public void run() {
        paint();
    }
}

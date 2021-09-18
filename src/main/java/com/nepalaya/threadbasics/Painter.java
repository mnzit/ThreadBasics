package com.nepalaya.threadbasics;

import java.time.Duration;
import java.time.Instant;

public class Painter implements Runnable {

    private String painting;
    private long timeTaken;
    private String name;

    public Painter(String name, String painting, long timeTaken) {
        this.name = name;
        this.painting = painting;
        this.timeTaken = timeTaken;
    }

    public void paint() {
        Instant before = Instant.now(); // Same like performing new Date();

        System.out.println(name + " started painting at: " + before);

        // stimulating/ faking painting
        try {
            Thread.sleep(1000 * timeTaken);
            System.out.println(new Painting(painting, name));
        } catch (InterruptedException ex) {
            System.err.println("Exception: " + ex.getMessage());
        }

        Instant after = Instant.now();
        System.out.println(name + " finished painting at: " + before);
        long timeTakenInMs = Duration.between(before, after).toMillis(); // this is difference between before and after
        System.out.println(name + " time taken: " + timeTakenInMs + "ms");
    }

    @Override
    public void run() {
        paint();
    }
}

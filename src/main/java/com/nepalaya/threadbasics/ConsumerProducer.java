package com.nepalaya.threadbasics;

import com.nepalaya.threadbasics2.Consumer;
import com.nepalaya.threadbasics2.Item;
import com.nepalaya.threadbasics2.Producer;

import java.util.stream.IntStream;

/**
 *
 * notifyAll(), wait()
 * Thread Intercommunication
 * Consumer -> consumes
 * Producer -> produces
 * 6 Consumers -> wait()
 * 2 Producers -> wait()
 * Capacity: 5 items only
 * Storage Type: Collection [item0, item1, item2, item3, item4]
 */
public class ConsumerProducer {

    public static void main(String[] args) {
        LimitedArrayList<Item> items = new LimitedArrayList<>(5);
        IntStream.range(0,6).forEach((v) -> new Thread(new Producer(items)).start());
        IntStream.range(0,6).forEach((v) -> new Thread(new Consumer(items)).start());
    }
}

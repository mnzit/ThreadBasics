package com.nepalaya.threadbasics2;

import com.nepalaya.threadbasics.LimitedArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;

@NoArgsConstructor
@AllArgsConstructor
public class Producer implements Runnable {

    private LimitedArrayList<Item> items;

    @Override
    public void run() {
        IntStream.range(0, 5).forEach((v) -> {
            System.out.println("Producing ["+items.size()+"]");
            synchronized (items) {
                if (items.getLimit() == items.size()) {
                    System.out.println("Items List is Full. Producer is now waiting");
                    ExceptionHandler.handle(() -> items.wait());
                    System.out.println("Producer wait finished. Got notified by Consumer");
                } else {
                    String currentThreadName = Thread.currentThread().getName();
                    Item item = new Item();
                    item.setProducerName(currentThreadName);
                    items.add(item);
                    System.out.println("Producer is going to notify the Consumer");
                    items.notifyAll();
                    System.out.println("Producer has notified the Consumer");
                }
            }
        });
    }
}

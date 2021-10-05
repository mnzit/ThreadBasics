package com.nepalaya.threadbasics2;

import com.nepalaya.threadbasics.LimitedArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;


@NoArgsConstructor
@AllArgsConstructor
public class Consumer implements Runnable {

    private LimitedArrayList<Item> items;

    @Override
    public void run() {
        IntStream.range(0, 5).forEach((v) -> {
            System.out.println("Consuming ["+items.size()+"]");
            synchronized (items) {
                if (items.isEmpty()) {
                    System.out.println("Items List is Empty. Consumer is now waiting");
                    ExceptionHandler.handle(() -> items.wait());
                    System.out.println("Consumer wait finished. Got notified by Producer");
                } else {
                    String currentThreadName = Thread.currentThread().getName();
                    Item item = new Item();
                    item.setConsumerName(currentThreadName);
                    items.remove(items.size() - 1);
                    System.out.println("Consumer is going to notify the Producer");
                    ExceptionHandler.handle(() -> Thread.sleep(3000));
                    items.notifyAll();
                    System.out.println("Consumer has notified the Producer");
                }
            }
        });
    }
}

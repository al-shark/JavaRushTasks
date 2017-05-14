package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by sharka on 14.05.2017.
 */
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                for (int i=0; i<queue.size(); i++) System.out.println(queue.take());
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}

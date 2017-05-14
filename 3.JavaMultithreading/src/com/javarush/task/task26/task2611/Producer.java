package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sharka on 14.05.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 1;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(Integer.toString(i),"Some text for "+i);
                i++;
                Thread.sleep(500);
                }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}

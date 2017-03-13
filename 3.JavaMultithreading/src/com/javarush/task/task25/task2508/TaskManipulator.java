package com.javarush.task.task25.task2508;

public class TaskManipulator implements CustomThreadManipulator, Runnable {
    Thread task;

    @Override
    public void run() {
        try {
        while (!Thread.currentThread().isInterrupted()) {
                task.sleep(0);
                System.out.println(Thread.currentThread().getName());
                task.sleep(100);
        }
            }
            catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
    }

    @Override
    public void start(String threadName) {
        task =new Thread(this,threadName);
        task.start();
    }

    @Override
    public void stop() {
        task.interrupt();
    }
}

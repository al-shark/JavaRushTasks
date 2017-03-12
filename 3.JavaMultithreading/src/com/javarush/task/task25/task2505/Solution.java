package com.javarush.task.task25.task2505;

import java.util.logging.Logger;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        Thread.sleep(1000);
    }

    public class MyThread extends Thread {
        private String secretKey;

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    t.sleep(500);
                    String err=String.format("%s, %s, %s",secretKey,t.getName(),e.getMessage());
                    System.out.println(err);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

